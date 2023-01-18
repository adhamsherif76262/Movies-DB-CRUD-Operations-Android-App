package com.example.lab_5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Movie_DB_Helper extends SQLiteOpenHelper {

    public   static  String databaseName = "movieDatabase";
    SQLiteDatabase movieDatabase;
    public Movie_DB_Helper(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table movie(id integer primary key, name text not null, description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists movie");
    }

    public  void  CreateNewMovie(String name , String description){
        ContentValues row = new ContentValues();
        row.put("name",name);
        row.put("description",description);
        movieDatabase = getWritableDatabase();
        movieDatabase.insert("movie",null,row);
        movieDatabase.close();
    }

    public Cursor fetchAllMovies(){

        movieDatabase = getReadableDatabase();
        String[] rowDetails = {"name","description","id"};
        Cursor cursor = movieDatabase.query("movie",rowDetails,null,null,null,null,null);
        if (cursor != null){cursor.moveToFirst();}
        //movieDatabase.delete("movie",null,null);
        movieDatabase.close();
        return cursor;
    }

    public void Clear_DB(){
        movieDatabase.delete("movie",null,null);
    }

    public String getMovieDesc(String name){
        movieDatabase = getReadableDatabase();
        String[] arg = {name};
        Cursor cursor = movieDatabase.rawQuery("Select description from movie where name like ?",arg);
        cursor.moveToFirst();
        movieDatabase.close();
        return  cursor.getString(0);
    }
}