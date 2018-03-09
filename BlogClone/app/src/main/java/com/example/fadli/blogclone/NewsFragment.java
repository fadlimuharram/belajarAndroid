package com.example.fadli.blogclone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private static final String apiURL="https://759b74ce43947f5f4c91aeddc3e5bad3d.codepolitan.com/api/v2/posts/category/news";

    ArrayList<News> kumpulanBerita = new ArrayList<>();
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


        rv = v.findViewById(R.id.rvNews);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new NewsListAdapter(kumpulanBerita,getContext());

        rv.setAdapter(adapter);

        ApiController api = new ApiController();
        api.setAdapter(adapter);
        api.setApiURL(apiURL);
        api.setKumpulanBerita(kumpulanBerita);
        api.readCodepolitanConent();
        return v;
    }



}
