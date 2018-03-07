package com.example.fadli.kalkulatorduaangka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    TextView hasil;
    Double tmpAngka1, tmpAngka2;

    public static String HASIL = "HASIL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = findViewById(R.id.angkapertama);
        angka2 = findViewById(R.id.angkakedua);
        hasil = findViewById(R.id.hasil);
    }



    public void funcTmp(){
        this.tmpAngka1 = Double.valueOf(angka1.getText().toString());
        this.tmpAngka2 = Double.valueOf(angka2.getText().toString());
    }

    public void toHasil(Double hasil){
        String hasilstr = String.valueOf(hasil);

        Intent pindahIntent = new Intent(MainActivity.this,HasilActivity.class);
        pindahIntent.putExtra(HASIL,hasilstr);
        startActivity(pindahIntent);
    }


    public void tambah(View view) {
        funcTmp();
        toHasil(this.tmpAngka1 + this.tmpAngka2);
    }

    public void kurang(View view) {
        funcTmp();
        toHasil(this.tmpAngka1 - this.tmpAngka2);
    }
    public void kali(View view) {
        funcTmp();
        toHasil(this.tmpAngka1 * this.tmpAngka2);
    }
    public void bagi(View view) {
        funcTmp();
        toHasil(this.tmpAngka1 / this.tmpAngka2);
    }
}
