package com.example.lab_5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab_5.Movie_DB_Helper;

public class ShowMovies extends AppCompatActivity {

    ListView movielist;
    ArrayAdapter<String> moviesAdapter;
    Movie_DB_Helper movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_movies);
        Button Clear_DB = (Button) findViewById(R.id.Clear_DB_Button);
        movielist = (ListView) findViewById(R.id.All_Movies_List_View);
        moviesAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        movielist.setAdapter(moviesAdapter);
        movies = new Movie_DB_Helper(getApplicationContext());
        Cursor cursor = movies.fetchAllMovies();
        while (!cursor.isAfterLast()){
            moviesAdapter.add(cursor.getString(0));
            cursor.moveToNext();
        }

        movielist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView desc = (TextView) findViewById(R.id.Selected_Movie_Description_Text_View);
                String Description = movies.getMovieDesc(((TextView)view).getText().toString());
                desc.setText(Description);
            }
        });

        Clear_DB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moviesAdapter.clear();
                Toast.makeText(getApplicationContext(),"Database Cleared",Toast.LENGTH_LONG).show();
            }
        });
    }
}