package com.example.rawanali.rawanfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView moviesRecyclerView;
    private MyRecyclerViewAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, numberOfColumns));
        moviesAdapter = new MyRecyclerViewAdapter();
        moviesAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(image movie) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Movie", movie);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(moviesAdapter);
        MoviesGetterTask moviesGetterTask = new MoviesGetterTask() {
            @Override
            protected void onPostExecute(List<image> movies) {
                moviesAdapter.setMovies(movies);
            }
        };
        moviesGetterTask.execute();

    }
}
