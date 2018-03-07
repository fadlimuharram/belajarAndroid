package com.example.fadli.kalkulatorduaangka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    String result;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        this.hasil = findViewById(R.id.hasilTV);
        /*
        selain melalui manifest dapat juga
        getActionBar().setTitle("abc");
         */

        this.result = getIntent().getStringExtra(MainActivity.HASIL);
        this.hasil.setText(this.result);
        Log.wtf("HASIL","HASIL HITUNG : " + this.result);
    }
}
