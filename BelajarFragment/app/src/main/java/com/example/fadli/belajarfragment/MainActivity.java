package com.example.fadli.belajarfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = findViewById(R.id.container);
    }

    public void tampilFragmentPertama(View view) {
        fm.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new PertamaFragment()).commit();
    }

    public void tampilFragmentKedua(View view) {
        fm.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new KeduaFragment()).commit();
    }

    public void tampilFragmentKetiga(View view) {
        fm.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new KetigaFragment()).commit();
    }

    public void tampilFragmentKeempat(View view) {
        fm.setVisibility(View.GONE);
    }
}
