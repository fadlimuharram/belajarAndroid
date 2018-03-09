package com.example.fadli.blogclone;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by fadli on 3/8/18.
 */

public class ApiController {

    ArrayList<News> kumpulanBerita = new ArrayList<>();
    String apiURL;
    NewsListAdapter adapter;

    public ApiController() {
    }

    public ApiController(ArrayList<News> kumpulanBerita, String apiURL, NewsListAdapter adapter) {
        this.kumpulanBerita = kumpulanBerita;
        this.apiURL = apiURL;
        this.adapter = adapter;
    }

    public ArrayList<News> getKumpulanBerita() {
        return kumpulanBerita;
    }

    public void setKumpulanBerita(ArrayList<News> kumpulanBerita) {
        this.kumpulanBerita = kumpulanBerita;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public NewsListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(NewsListAdapter adapter) {
        this.adapter = adapter;
    }

    public void readCodepolitanConent(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(apiURL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                Log.wtf("Berita","OnStart: Proses Pembacaan Api dimulai");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.wtf("Berita","OnSuccess: Pembacaan data api berhasil");

                try {
                    JSONObject jObj = new JSONObject(new String(responseBody));
                    JSONArray hasil = jObj.getJSONArray("result");
                    kumpulanBerita.clear();
                    for (int i=0;i<hasil.length();i++){
                        JSONObject objNewsJson = hasil.getJSONObject(i);
                        String id = objNewsJson.getString("id");
                        String slug = objNewsJson.getString("slug");
                        String title = objNewsJson.getString("title");
                        String author_name = objNewsJson.getString("author_name");
                        String author_image = objNewsJson.getString("author_image");
                        String description = objNewsJson.getString("description");
                        String date = objNewsJson.getString("date");
                        String link = objNewsJson.getString("link");
                        String thumbnail = objNewsJson.getString("thumbnail");
                        String total_views = objNewsJson.getString("total_views");
                        Log.wtf("tess dari " + i, link);
                        News newsbaru = new News(id,slug,title,author_name,author_image,description,date,link,thumbnail,total_views);
                        kumpulanBerita.add(newsbaru);

                    }
                    adapter.notifyDataSetChanged();

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.wtf("Berita","OnFailure : Pembacaan data gagal dengan kode " + statusCode);
                Log.wtf("ws", "---->>onFailure : " + error);

            }

            @Override
            public void onRetry(int retryNo) {
                Log.wtf("Berita","OnRetry : Melakukan pembacaan ulang api");
            }
        });

    }
}
