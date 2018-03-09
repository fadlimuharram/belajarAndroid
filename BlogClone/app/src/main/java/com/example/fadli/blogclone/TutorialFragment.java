package com.example.fadli.blogclone;


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
public class TutorialFragment extends Fragment {

    private static final String apiURL="https://759b74ce43947f5f4c91aeddc3e5bad3d.codepolitan.com/api/v2/posts/category/tutorial";

    ArrayList<News> kumpulanBerita = new ArrayList<>();
    RecyclerView rv;
    NewsListAdapter adapter;

    public TutorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tutorial, container, false);

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
