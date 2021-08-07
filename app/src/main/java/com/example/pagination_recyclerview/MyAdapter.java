package com.example.pagination_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private Context context;
    private ArrayList<ListItem> listItems;


    public MyAdapter( Context context, ArrayList<ListItem> listItems) {

        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.headText.setText(listItems.get(position).getHead());
        holder.descText.setText(listItems.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView headText;
        TextView descText;
        public ViewHolder(View itemView) {
            super(itemView);
            headText=itemView.findViewById(R.id.headText);
            descText=itemView.findViewById(R.id.descText);
        }
    }
}