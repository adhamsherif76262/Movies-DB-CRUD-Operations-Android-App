package com.example.assignment5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Employees_Database extends SQLiteOpenHelper {
    final private    static  String databaseName = "Employees_Database";
    SQLiteDatabase Employees_Db;
    public Employees_Database(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table department(DeptID integer primary key autoincrement, Name text);");

        sqLiteDatabase.execSQL("create table employee(EmpID integer primary key autoincrement, " +
                "Name text not null, Title text not null, Phone text not null, Email text not null, " +
                "Dept_id integer, FOREIGN KEY(Dept_id) REFERENCES Department (DeptID));");
    }

    public void Delete(){
        Employees_Db.execSQL("DELETE FROM employee");
        Employees_Db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Employee");
        sqLiteDatabase.execSQL("drop table if exists Department");
        onCreate(sqLiteDatabase);
    }

    public void createNewDepartment(String Name) {
        Employees_Db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("Name", Name);
        Employees_Db.insert("department", null, row);
        Employees_Db.close();
    }

    public void createNewEmployee(String Name, String Title, String Phone, String Email, int Dept_id) {
        Employees_Db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("Name", Name);
        row.put("Title", Title);
        row.put("Phone", Phone);
        row.put("Email", Email);
        row.put("Dept_id", Dept_id);
        Employees_Db.insert("employee", null, row);
        Employees_Db.close();
    }

    public Cursor Get_Employees(String name) {
        Employees_Db = getReadableDatabase();
        String[] columns = {"Name"};
        String selection = "Name = ?";
        String[] args = {name};
        args.toString().toLowerCase();
        Cursor cursor = Employees_Db.query("employee", columns, selection, args, null , null, null);
        return cursor;
    }

    public Cursor Get_Employee_Phone(String name) {
        Employees_Db = getReadableDatabase();
        String[] columns = {"Phone"};
        String selection = "Name = ?";
        String[] args = {name};
        args.toString().toLowerCase();
        Cursor cursor = Employees_Db.query("employee", columns, selection, args, null , null, null);
        return cursor;
    }
    public Cursor Get_Employee_Email(String name) {
        Employees_Db = getReadableDatabase();
        String[] columns = {"Email"};
        String selection = "Name = ?";
        String[] args = {name};
        args.toString().toLowerCase();
        Cursor cursor = Employees_Db.query("employee", columns, selection, args, null , null, null);
        return cursor;
    }
    public Cursor Get_Employee_Title(String name) {
        Employees_Db = getReadableDatabase();
        String[] columns = {"Title"};
        String selection = "Name = ?";
        String[] args = {name};
        args.toString().toLowerCase();
        Cursor cursor = Employees_Db.query("employee", columns, selection, args, null , null, null);
        return cursor;
    }
    public Cursor Get_Employee_Department_ID(String name) {
        Employees_Db = getReadableDatabase();
        String[] columns = {"Dept_id"};
        String selection = "Name = ?";
        String[] args = {name};
        Cursor cursor = Employees_Db.query("employee", columns, selection, args, null , null, null);
//      Get_Employee_Department_Name(cursor);
      return cursor;
    }
//    public Cursor Get_Employee_Department_Name(Cursor cursor) {
//        Employees_Db = getReadableDatabase();
//
//
//        String[] columns_2 = {"Name"};
//        String selection_2 = "DeptID = ?";
//
//
//        Cursor cursor2 = Employees_Db.query("department", columns_2, selection_2, cursor.getColumnNames(), null , null, null);
//        //String[] ID = new String[0];
//        //Cursor cursor2 =Employees_Db.query("department",columns_2,selection_2,null,null,null,null);
////        int columnIndex = cursor.getColumnIndex("Name");
////        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
////            ID.add(cursor.getString(columnIndex));
////            cursor.to
////
//        //List<String> quotes = new ArrayList<>();
////        QuotesDatabaseHelper.QuoteCursor quoteCursor = mHelper.queryQuotes();
//
//
//        //Cursor cursor2 =Employees_Db.rawQuery("Select Name from department where DeptID like ?", cursor.getColumnNames());
//        return cursor2;
//    }
}
