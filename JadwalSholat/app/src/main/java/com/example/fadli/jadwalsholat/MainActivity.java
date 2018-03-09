package com.example.fadli.jadwalsholat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    TextView dzuhur,ashar,magrib,isya,shubuh;
    ImageView gambar;
    EditText lokasiInput;

    private String apiURL = "http://muslimsalat.com/location/";

    private void init(){
        dzuhur = findViewById(R.id.ltDzuhur);
        ashar = findViewById(R.id.ltAshar);
        magrib = findViewById(R.id.ltMagrib);
        isya = findViewById(R.id.ltIsya);
        shubuh = findViewById(R.id.ltShubuh);
        gambar = findViewById(R.id.ltMainGambarLokasi);
        lokasiInput = findViewById(R.id.etLokasi);
    }

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

        init();

        refreshApi("Bandung");

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

    private void refreshApi(String lokasi){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(apiURL + lokasi + ".json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                Log.wtf("Jadwal","onSuccess : ada di on success function");
                try {
                    JSONObject jObj = new JSONObject(new String(responseBody));
                    JSONObject tWetather = jObj.getJSONObject("today_weather");
                    Log.wtf("tes weather", tWetather.getString("temperature"));


                    if(jObj.getString("status_description").equals("Failed.")){
                        Toast.makeText(getBaseContext(), "Data Yang Di Masukan Tidak Valid, Kembali Ke Default",Toast.LENGTH_LONG).show();
                        refreshApi("Bandung");
                    }else {
                        JSONArray jItems = jObj.getJSONArray("items");
                        dzuhur.setText(jItems.getJSONObject(0).getString("dhuhr"));
                        ashar.setText(jItems.getJSONObject(0).getString("asr"));
                        magrib.setText(jItems.getJSONObject(0).getString("maghrib"));
                        isya.setText(jItems.getJSONObject(0).getString("isha"));
                        shubuh.setText(jItems.getJSONObject(0).getString("fajr"));

                        Picasso.with(getBaseContext()).load(jObj.getString("map_image")).into(gambar);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.wtf("Jadwal","OnFailur : status Code : " + statusCode);
                Log.wtf("Jadwal","---->Error : " + error);
            }
        });
    }

    public void ubahLokasi(View view) {

        refreshApi(lokasiInput.getText().toString());
    }
}
