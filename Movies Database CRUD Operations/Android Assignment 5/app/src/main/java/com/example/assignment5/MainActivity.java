package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Employees_Database Emp_Db = new Employees_Database(getApplicationContext());
        boolean firstTime = true;
        if (firstTime){
        Emp_Db.createNewDepartment("Sales");
        Emp_Db.createNewDepartment("Development");
        Emp_Db.createNewDepartment("HR");

        Emp_Db.createNewEmployee("ahmad", "Game Developer", "01128887317", "ahmad.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("ahmad", "Game Developer", "01128887317", "ahmad.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("ahmad", "Game Developer", "01128887317", "ahmad.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("omar", "Game Developer", "01095313909", "omar.diaa@gmail.com", 1);
        Emp_Db.createNewEmployee("saif", "Sales Executive", "01105698879", "saif.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("saif", "Sales Executive", "01105698879", "saif.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("saif", "Sales Executive", "01105698879", "saif.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("saif", "Sales Executive", "01105698879", "saif.taher,elhanafy@gmail.com", 0);
        Emp_Db.createNewEmployee("taher", "HR Representative", "01296546655", "taher,elhanafy@gmail.com", 1);
        Emp_Db.createNewEmployee("taher", "HR Representative", "01296546655", "taher,elhanafy@gmail.com", 1);
        firstTime = false;
        }

        Button Search_Button = (Button) findViewById(R.id.Search_Button);
//        Button Graph_Button = (Button) findViewById(R.id.graph_button);
//        Graph_Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        ListView My_List = (ListView)findViewById(R.id.List_View);
        ArrayAdapter<String> Emp_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        EditText Employee_Name = (EditText) findViewById(R.id.Employee_Name_Edit_Text);
        My_List.setAdapter(Emp_Adapter);
        Search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Emp_Adapter.clear();
                Cursor cursor = Emp_Db.Get_Employees(Employee_Name.getText().toString());
                if (cursor != null && cursor.moveToFirst()) {
                    do
                    {
                        Emp_Adapter.add(cursor.getString(0));
                    }
                    while(cursor.moveToNext());
                }
                //Emp_Db.Delete();
                cursor.close();
            }
        });

        My_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Selected_Employee = (String) adapterView.getItemAtPosition(i);
                Intent Employee_Details = new Intent(MainActivity.this,Employee_Details.class);
                Employee_Details.putExtra("Key",Selected_Employee);
                startActivity(Employee_Details);
            }
        });
    }
}