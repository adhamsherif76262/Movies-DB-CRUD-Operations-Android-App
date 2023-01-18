package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Employee_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        Employees_Database Emp_Db = new Employees_Database(getApplicationContext());
        TextView Name_Text_View = (TextView) findViewById(R.id.Name_Text_View_2);
        TextView Title_Text_View = (TextView) findViewById(R.id.Title_Text_View_2);
        TextView Phone_Text_View = (TextView) findViewById(R.id.Phone_Text_View_2);
        TextView Email_Text_View = (TextView) findViewById(R.id.Email_Text_View_2);
        TextView Department_Text_View = (TextView) findViewById(R.id.Department_Text_View_2);

        Intent intent = getIntent();
        String str = intent.getStringExtra("Key");

        Name_Text_View.setText(str);

        Cursor cursor = Emp_Db.Get_Employee_Title(str);
        if (cursor != null && cursor.moveToFirst()) {
            do
            {
                Title_Text_View.setText(cursor.getString(0));
            }
            while(cursor.moveToNext());
        }
        cursor.close();

        cursor = Emp_Db.Get_Employee_Phone(str);
        if (cursor != null && cursor.moveToFirst()) {
            do
            {
                Phone_Text_View.setText(cursor.getString(0));
            }
            while(cursor.moveToNext());
        }
        cursor.close();

        cursor = Emp_Db.Get_Employee_Email(str);
        if (cursor != null && cursor.moveToFirst()) {
            do
            {
                Email_Text_View.setText(cursor.getString(0));
            }
            while(cursor.moveToNext());
        }
        cursor.close();

        cursor = Emp_Db.Get_Employee_Department_ID(str);
        if (cursor != null && cursor.moveToFirst()) {
            do
            {
                Department_Text_View.setText(cursor.getString(0));
            }
            while(cursor.moveToNext());
        }
        cursor.close();
    }
}