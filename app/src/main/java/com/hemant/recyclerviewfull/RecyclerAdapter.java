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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myviewholder> implements Filterable {

    private static final String TAG = "RecyclerviewAdapter";

    List<String> movieslist;
    List<String> moviesListAll;


    public RecyclerAdapter(List<String> movieslist) {
        this.movieslist = movieslist;
        moviesListAll=new ArrayList<>();
        moviesListAll.addAll(movieslist);

    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_iitem,parent,false);
        Myviewholder myviewholder = new Myviewholder(view);

        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

        holder.textView2.setText(String.valueOf(position));
        holder.textView.setText(movieslist.get(position));
        holder.imageView.setImageResource(R.drawable.hemant);

    }

    @Override
    public int getItemCount() {
        return movieslist.size();
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }
    Filter myFilter = new Filter() {


        // Run on background Thread;
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<String > filteredlist = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                filteredlist.addAll(moviesListAll);

            }else {
                for (String movie: moviesListAll){

                    if (movie.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredlist.add(movie);
                    }

                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredlist;
            return filterResults;

        }
//Rup on Main Thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            movieslist.clear();
            movieslist.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();
        }

    };

    class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView,textView2;

        public Myviewholder(@NonNull View itemView) {

            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
            textView =(TextView)itemView.findViewById(R.id.title) ;
            textView2= itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(this);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    recyclerviewClickInterface.onItemClick(getAdapterPosition());
//                }
//            });
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
////                    movieslist.remove(getAdapterPosition());
////                    notifyItemRemoved(getAdapterPosition());
//
//                    recyclerviewClickInterface.onLongItemClick(getAdapterPosition());
//                    return true;
//                }
//            });

        }

        @Override
        public void onClick(View v) {

            Toast.makeText(v.getContext(),movieslist.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
        }

        }

////        @Override
////        public void onClick(View v) {
////
////            //To know the adapter position use getAdapterPosition() method.
////
////            Toast.makeText(v.getContext(),movieslist.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
////        }
//    }
}
