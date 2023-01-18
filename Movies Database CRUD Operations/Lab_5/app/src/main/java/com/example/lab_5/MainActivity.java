package com.example.lab_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab_5.Movie_DB_Helper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = (Button) findViewById(R.id.Add_Movie_Button);
        Button show = (Button) findViewById(R.id.Show_All_Movies_Button);
        Button To_Search_Activity = (Button) findViewById(R.id.To_Search_Activity_Button);
        final EditText name = (EditText) findViewById(R.id.Movie_Name_Edit_Text);
        final EditText desc = (EditText) findViewById(R.id.movie_Description_Edit_Text);
        final Movie_DB_Helper newMovie = new Movie_DB_Helper(this);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newMovie.CreateNewMovie(name.getText().toString(),desc.getText().toString());
                Toast.makeText(getApplicationContext(), "A New Movie Has Been Added", Toast.LENGTH_LONG).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allMovies = new Intent(MainActivity.this,ShowMovies.class);
                startActivity(allMovies);
            }
        });

        To_Search_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Search_Emps = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(Search_Emps);
            }
        });
    }
}