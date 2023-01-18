package com.example.lab_5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Employees_Database extends SQLiteOpenHelper {
    public   static  String databaseName = "Employees_Database";
    SQLiteDatabase Employees_Db;
    public Employees_Database(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Department(Dept_ID integer primary key autoincrement, name text)");
        sqLiteDatabase.execSQL("create table Employee(Emp_ID integer primary key autoincrement, name text not null," +
                "Title text not null, Phone text not null, Email text not null, Dept_Id integer," +
                "FOREIGN KEY(Dept_Id) REFERENCES Department (Dept_ID))");

        ContentValues row = new ContentValues();
        row.put("name","Ahmed_Sayed");
        row.put("name","Omar_Ahmed");
        row.put("name","Adham_Hamed");
        row.put("name","Abdelrahman_Ahmed_Hamed");
        row.put("name","Hamed_Zaki");
        Employees_Db = getWritableDatabase();
        Employees_Db.insert("Employee",null,row);
        Employees_Db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Employee");
        sqLiteDatabase.execSQL("drop table if exists Department");
        onCreate(sqLiteDatabase);
    }

    public String Get_Employees(String name){
        Employees_Db = getReadableDatabase();
        String[] arg = {name};
        Cursor cursor = Employees_Db.rawQuery("Select name from Employee where name like ?",arg);
        cursor.moveToFirst();
        Employees_Db.close();
        return  cursor.getString(0);
    }
}
