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



        movieslist.add("dhoom");
        movieslist.add("Gunday");
        movieslist.add("Qayamat");
        movieslist.add("Shivaji");
        movieslist.add("waqt");
        movieslist.add("Good news");
        movieslist.add("Dil");
        movieslist.add("Mohabatte");
        movieslist.add("dissum");
        movieslist.add("har dil jo pyar karega");
        movieslist.add("waada");
        movieslist.add("asd");
        movieslist.add("abcd");
        movieslist.add("devdas");
        movieslist.add("baazirao");
        movieslist.add("world war");
        movieslist.add("waada");
        movieslist.add("asd");
        movieslist.add("abcd");
        movieslist.add("devdas");
        movieslist.add("baazirao");
        movieslist.add("world war");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(movieslist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
