package com.example.fadli.viewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    ArrayList<News> kumpulanNews = new ArrayList<>();
    RecyclerView rv;
    NewsListAdapter adapter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        for (int i=0;i<10;i++){
            News news = new News();
            news.setId(i + "1");
            news.setTitle("Belajar Python");
            news.setThumbnail("https://static.cdn-cdpl.com/270x135/lock.jpg");

            kumpulanNews.add(news);
        }
        rv = v.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new NewsListAdapter(kumpulanNews,getContext());
        rv.setAdapter(adapter);
        return v;
    }

}
