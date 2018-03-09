package com.example.fadli.blogclone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    public static String JUDULNEWS="JUDUL";
//    public static String COVERNEWS="COVER";
//    public static String OLEHNEWS="OLEH";
//    public static String PARAGRAPHNEWS="PARAGRAPH";
      public static String ARTIKELNEWS="ARTIKELNEWS";
      public static String LINKNEWS="LINKNEWS";


    ArrayList<News> data;
    Context contex;

    public NewsListAdapter(ArrayList<News> data, Context contex) {
        this.data = data;
        this.contex = contex;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contex).inflate(R.layout.newslayout,parent,false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        final News news = data.get(position);

        holder.tvJudul.setText(news.getTitle());
        holder.tvOleh.setText(news.getAuthor_name());

        Picasso.with(contex).load(news.getThumbnail()).into(holder.ivCover);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent pindah = new Intent(contex,ReadMoreActivity.class);
                Log.wtf("tess rrrr ", news.getLink());
                pindah.putExtra(LINKNEWS,news.getLink());
                pindah.putExtra(JUDULNEWS,news.getTitle());

                contex.startActivity(pindah);
            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class NewsViewHolder extends  RecyclerView.ViewHolder{
        TextView tvJudul, tvOleh;
        ImageView ivCover;


        public NewsViewHolder(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.judul);
            ivCover = itemView.findViewById(R.id.cover);
            tvOleh = itemView.findViewById(R.id.oleh);
        }
    }
}
