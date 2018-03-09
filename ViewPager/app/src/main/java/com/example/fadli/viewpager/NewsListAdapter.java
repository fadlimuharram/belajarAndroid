package com.example.fadli.viewpager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by fadli on 3/7/18.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    ArrayList<News> data;
    Context context;

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul;
        ImageView ivCover;

        public NewsViewHolder(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            ivCover = itemView.findViewById(R.id.ivConver);
        }
    }

    public NewsListAdapter(ArrayList<News> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View v = LayoutInflater.from(context).inflate(R.layout.news,parent,false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder,int position){
        News news = data.get(position);

        holder.tvJudul.setText(news.getTitle());

        Picasso.with(context).load(news.getThumbnail()).into(holder.ivCover);

    }

    @Override
    public int getItemCount(){
        return data.size();
    }

}
