package com.hemant.recyclerviewfull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewClickInterface{
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<String> movieslist;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieslist = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(movieslist,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);


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


        swipeRefreshLayout =(SwipeRefreshLayout)findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                movieslist.add("Refresh");
                recyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }
        });

    }

    @Override
    public void onItemClick(int position) {

        Toast.makeText(this,movieslist.get(position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(int position) {
        movieslist.remove(position);
        recyclerAdapter.notifyItemRemoved(position);
    }
}
