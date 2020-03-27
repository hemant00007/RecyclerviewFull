package com.hemant.recyclerviewfull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    String deletedMovie = null;
    List<String> archivedMovies = new ArrayList<>();

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            final int position = viewHolder.getAdapterPosition();

            switch (direction){
                case ItemTouchHelper.LEFT:
                    deletedMovie=movieslist.get(position);
                    movieslist.remove(position);
                    recyclerAdapter.notifyItemRemoved(position);
                    Snackbar.make(recyclerView,deletedMovie,Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                movieslist.add(position,deletedMovie);
                                recyclerAdapter.notifyItemInserted(position);
                                }
                            }).show();

                    break;

                    case ItemTouchHelper.RIGHT:
                               final String moviename=movieslist.get(position);
                               archivedMovies.add(moviename);
                               recyclerAdapter.notifyItemRemoved(position);
                        Snackbar.make(recyclerView,moviename +"Archived",Snackbar.LENGTH_LONG)
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                      archivedMovies.remove(archivedMovies.lastIndexOf(moviename));
                                      movieslist.add(position,moviename);
                                      recyclerAdapter.notifyItemInserted(position);
                                    }
                                }).show();

                        break;
            }

        }

        @Override
        public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent))
                    .addSwipeLeftActionIcon(R.drawable.ic_delete_black_24dp)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark))
                    .addSwipeRightActionIcon(R.drawable.ic_archive_black_24dp)
                    .create()
                    .decorate();

            super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    @Override
    public void onItemClick(int position) {

        Toast.makeText(this,movieslist.get(position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(int position) {
//        movieslist.remove(position);
//        recyclerAdapter.notifyItemRemoved(position);
    }
}
