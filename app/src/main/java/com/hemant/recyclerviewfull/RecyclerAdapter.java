package com.hemant.recyclerviewfull;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private static final String TAG = "RecyclerviewAdapter";

    List<String> movieslist;



    public RecyclerAdapter(List<String> movieslist) {
        this.movieslist = movieslist;
    }

    @Override
    public int getItemViewType(int position) {
       if (movieslist.get(position).toLowerCase().contains("avengers")){
           return 0;
       }
       return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType==0){
            view = layoutInflater.inflate(R.layout.row_iitem,parent,false);
            return new ViewHolderOne(view);
        }
        view = layoutInflater.inflate(R.layout.another_row_item,parent,false);
        return new ViewHolderTwo(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (movieslist.get(position).toLowerCase().contains("avengers")){
            //bind viewholder one
            ViewHolderOne holderOne = (ViewHolderOne) holder;
            holderOne.titel.setText(movieslist.get(position));
            holderOne.rowcount.setText(String.valueOf(position));
            holderOne.imageView.setImageResource(R.drawable.hemant);

        }else {
            //bind viewholder two
            ViewHolderTwo holderTwo = (ViewHolderTwo) holder;
            holderTwo.title.setText(movieslist.get(position));
            holderTwo.rowcount.setText(String.valueOf(position));
        }

    }

    @Override
    public int getItemCount() {
        return movieslist.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{

        TextView titel,rowcount;
        ImageView imageView;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            titel =itemView.findViewById(R.id.title);
            rowcount=itemView.findViewById(R.id.desc);
            imageView=itemView.findViewById(R.id.image_view);
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {
        TextView title,rowcount;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.title);
            rowcount=itemView.findViewById(R.id.desc);
        }
    }
}
