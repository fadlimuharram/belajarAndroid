package com.example.fadli.blogclone;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {


    ViewPager myViewPager;
    MyPagerAdapter adapterViewPager;
    TabLayout tbLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        News news1 = new News();
//        news1.setId("1");
//        news1.setTitle("Apakah Data Email dan Password Saya Sudah Diketahui Hacker? Ini Cara Memeriksanya");
//        news1.setThumbnail("https://static.cdn-cdpl.com/270x135/lock.jpg");
//        news1.setAuthor_name("Fadli Muharram");
//        news1.setDescription("Morbi faucibus egestas ultrices. Mauris sodales gravida diam, nec porttitor mauris dictum euismod. Pellentesque aliquet, orci a accumsan molestie, leo risus ultrices nibh, sit amet fermentum mauris mi sit amet felis. Praesent felis velit, eleifend non sollicitudin in, eleifend nec diam. Morbi nibh tellus, blandit eget leo et, sodales pellentesque risus. Integer aliquet dignissim mattis. Cras molestie mi sed diam cursus, id commodo lacus pellentesque.\n" +
//                "\n" +
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc aliquam, justo vitae fringilla venenatis, ante neque ornare nisl, ut scelerisque nisi ex nec nisl. Curabitur euismod erat eget semper tincidunt. Morbi maximus ultrices felis, ac mattis leo blandit nec. Nullam dignissim id risus nec mollis. Pellentesque dictum velit sit amet rutrum dictum. Cras tincidunt fermentum ante id tincidunt.");
//        kumpulanBerita.add(news1);
//
//        News news2 = new News();
//        news2.setId("1");
//        news2.setTitle("7 Alasan Kenapa Kita Harus Mulai Belajar Kotlin Untuk Android di 2018");
//        news2.setThumbnail("https://static.cdn-cdpl.com/270x135/kotlinvsjava.png");
//        news2.setAuthor_name("Misaka Mikoto");
//        news2.setDescription("Aliquam aliquam justo sed risus volutpat viverra. Morbi eu magna iaculis, vehicula nisl sit amet, cursus nisi. Nam efficitur, elit a laoreet maximus, enim est tempor magna, tincidunt egestas elit nibh sit amet lectus. Pellentesque bibendum ultrices nibh in fringilla. Maecenas risus lorem, volutpat a vehicula eu, vehicula tempus sapien. Mauris risus est, lacinia sit amet nulla sit amet, venenatis rhoncus leo. Vestibulum vel condimentum est. Aliquam ut velit id neque elementum eleifend ultricies a massa. Curabitur sollicitudin posuere nisl, a accumsan ligula tincidunt nec. Nam ac posuere urna.");
//        kumpulanBerita.add(news2);
//
//        News news3 = new News();
//        news3.setId("1");
//        news3.setTitle("Anand Prakash, Sang Hacker Bertopi Putih Pencari Bug Facebook, Twitter, dan Uber");
//        news3.setThumbnail("https://static.cdn-cdpl.com/270x135/1_1uAQQ2BnZTIwaEYUsQ-Xbw.jpg");
//        news3.setAuthor_name("Misaka Mikoto");
//        news3.setDescription("Morbi faucibus egestas ultrices. Mauris sodales gravida diam, nec porttitor mauris dictum euismod. Pellentesque aliquet, orci a accumsan molestie, leo risus ultrices nibh, sit amet fermentum mauris mi sit amet felis. Praesent felis velit, eleifend non sollicitudin in, eleifend nec diam. Morbi nibh tellus, blandit eget leo et, sodales pellentesque risus. Integer aliquet dignissim mattis. Cras molestie mi sed diam cursus, id commodo lacus pellentesque.");
//        kumpulanBerita.add(news3);
//
//        News news4 = new News();
//        news4.setId("1");
//        news4.setTitle("Developer Ini Mereka Ulang Adegan Film The Ring dengan Augmented Reality");
//        news4.setThumbnail("https://static.cdn-cdpl.com/270x135/Screenshot_from_2018-02-23_11-18-40.png");
//        news4.setAuthor_name("Misaka Mikoto");
//        news4.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc aliquam, justo vitae fringilla venenatis, ante neque ornare nisl, ut scelerisque nisi ex nec nisl. Curabitur euismod erat eget semper tincidunt. Morbi maximus ultrices felis, ac mattis leo blandit nec. Nullam dignissim id risus nec mollis. Pellentesque dictum velit sit amet rutrum dictum. Cras tincidunt fermentum ante id tincidunt.");
//        kumpulanBerita.add(news4);
//
//        News news5 = new News();
//        news5.setId("1");
//        news5.setTitle("Permainan Offline yang Cocok Dimainkan Programmer Sambil Istirahat");
//        news5.setThumbnail("https://static.cdn-cdpl.com/270x135/pexels-photo-459762.jpg");
//        news5.setAuthor_name("Fadli Muharram");
//        news5.setDescription("Sed eget nisi at tellus iaculis efficitur. Donec aliquet erat nisi, vel porta arcu dignissim et. Pellentesque ac arcu finibus, consectetur nibh sed, laoreet turpis. Sed in sodales velit, ac malesuada felis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras fermentum diam felis, sit amet ornare nulla rhoncus eget. Mauris velit enim, congue quis lectus at, sagittis auctor ante. Phasellus et imperdiet diam. Aliquam sollicitudin nulla nec varius vulputate. Mauris eu ornare lacus. Morbi pharetra dignissim orci in malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis vestibulum elit quam, nec convallis turpis fermentum ac. Proin facilisis malesuada ante vel tempor. Cras feugiat enim vitae congue ullamcorper. In tortor ligula, efficitur molestie porta sed, maximus quis arcu.");
//        kumpulanBerita.add(news5);

        //readCodepolitanConent();

//        rv = findViewById(R.id.rvNews);
//        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//
//        adapter = new NewsListAdapter(kumpulanBerita,getBaseContext());
//
//        rv.setAdapter(adapter);

        myViewPager = findViewById(R.id.vPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

        myViewPager.setAdapter(adapterViewPager);

        tbLayout = findViewById(R.id.tabLayout);
        tbLayout.setupWithViewPager(myViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
