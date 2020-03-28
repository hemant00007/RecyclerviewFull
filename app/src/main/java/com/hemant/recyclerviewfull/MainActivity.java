package com.hemant.recyclerviewfull;


import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



import java.util.ArrayList;

import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<String> movieslist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieslist = new ArrayList<>();



        movieslist.add("Iron Man");
        movieslist.add("The Incredible Hulk");
        movieslist.add("Iron Man 2");
        movieslist.add("Thor");
        movieslist.add("Captain America: The First Avenger");
        movieslist.add("The Avengers");
        movieslist.add("Iron Man 3");
        movieslist.add("Thor: The Dark World");
        movieslist.add("Captain America: The Winter Soldier");
        movieslist.add("Guardians of the Galaxy");
        movieslist.add("Avengers: Age of Ultron");
        movieslist.add("Ant-Man");
        movieslist.add("Captain America: Civil War");
        movieslist.add("Doctor Strange");
        movieslist.add("Guardians of the Galaxy Vol. 2");
        movieslist.add("Spider-Man: Homecoming");
        movieslist.add("Thor: Ragnarok");
        movieslist.add("Black Panther");
        movieslist.add("Avengers: Infinity War");
        movieslist.add("Ant-Man and the Wasp");
        movieslist.add("Captain Marvel");
        movieslist.add("Avengers: Endgame");
        movieslist.add("Spider-Man: Far From Home");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(movieslist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

    }


}
