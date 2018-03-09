package com.example.fadli.belajarfragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = findViewById(R.id.container);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_lingkaran:
                    fm.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().add(R.id.container,new KetigaFragment()).commit();
                    return true;
                case R.id.nav_segitiga:
                    fm.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().add(R.id.container,new KeduaFragment()).commit();
                    return true;
                case R.id.nav_persegipanjang:
                    fm.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().add(R.id.container,new PertamaFragment()).commit();
                    return true;
            }
            return false;
        }
    };

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
