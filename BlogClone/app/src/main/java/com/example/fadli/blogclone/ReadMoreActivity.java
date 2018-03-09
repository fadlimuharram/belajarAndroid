package com.example.fadli.blogclone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ReadMoreActivity extends AppCompatActivity {
//    TextView tvTitle, tvOleh, tvParagraph;
//    ImageView ivCover;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);

//        tvTitle = findViewById(R.id.readMoreTitle);
//        tvOleh = findViewById(R.id.readMoreOleh);
//        tvParagraph = findViewById(R.id.readmoreParagraph);
//        ivCover = findViewById(R.id.readMoreCover);
//
//        tvTitle.setText(getIntent().getStringExtra(NewsListAdapter.JUDULNEWS));
//        tvOleh.setText(getIntent().getStringExtra(NewsListAdapter.OLEHNEWS));
//        tvParagraph.setText(getIntent().getStringExtra(NewsListAdapter.PARAGRAPHNEWS));
//
//        Picasso.with(getBaseContext()).load(getIntent().getStringExtra(NewsListAdapter.COVERNEWS)).into(ivCover);
//        Bundle data = getIntent().getExtras();
//        News artikelNews = data.getParcelable(NewsListAdapter.ARTIKELNEWS);


        webview = findViewById(R.id.browser);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(getIntent().getStringExtra(NewsListAdapter.LINKNEWS));

        getSupportActionBar().setTitle(getIntent().getStringExtra(NewsListAdapter.JUDULNEWS));

    }
}
