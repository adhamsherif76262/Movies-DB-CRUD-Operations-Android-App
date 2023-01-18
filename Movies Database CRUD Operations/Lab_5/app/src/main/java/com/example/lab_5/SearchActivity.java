package com.example.lab_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button Search_Button = (Button) findViewById(R.id.Search_Button);
        ListView My_List = (ListView)findViewById(R.id.List_View);
        Employees_Database Emp_Db = new Employees_Database(getApplicationContext());
        ArrayAdapter<String> Emp_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        My_List.setAdapter(Emp_Adapter);
        EditText Employee_Name = (EditText) findViewById(R.id.Employee_Name_Edit_Text);
        My_List.setAdapter(Emp_Adapter);

        SearchView SR = (SearchView) findViewById(R.id.searchView);


//        SR.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Emp_Adapter.add("B");
//
//                Emp_Adapter.add(Emp_Db.Get_Employees(((EditText)view).getText().toString()));
//                My_List.setAdapter(Emp_Adapter);
//            }
//        });

        Search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String Emp = Emp_Db.Get_Employees(((EditText)view).getText().toString());
                String Emp = Emp_Db.Get_Employees("Ahmed_Sayed");
                // String Emp = "Ahmed_Sayed";

                Toast.makeText(getApplicationContext(),Emp,Toast.LENGTH_LONG).show();
                Emp_Adapter.add(Emp);

//                Emp_Adapter.add(Emp_Db.Get_Employees(((EditText)view).getText().toString()));
//                Cursor cursor = Emp_Db.Get_Employees(((EditText)view).getText().toString());
//
//                while (!cursor.isAfterLast()){
//                    Emp_Adapter.add(cursor.getString(0));
//                    cursor.moveToNext();
//                }
                //Emp_Adapter.add(Emp_Db.Get_Employees(((EditText)view).getText().toString()));
            }
        });

    }
}