package com.example.fadli.holiday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int gambar;
    String judul,oleh,paragraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toBaca(){
        Intent pindah = new Intent(MainActivity.this,BacaActivity.class);
        pindah.putExtra(BacaActivity.bacaGambar,this.gambar);
        pindah.putExtra(BacaActivity.bacaJudul,this.judul);
        pindah.putExtra(BacaActivity.bacaOleh,this.oleh);
        pindah.putExtra(BacaActivity.bacaParagraph,this.paragraph);
        startActivity(pindah);
    }

    public void lombokClick(View view) {
        gambar = R.drawable.gunungrinjanipulaulombok;
        judul = "Gunung Rinjani (Pulau Lombok)";
        oleh = "Fadli Muharram";
        paragraph = "Gunung Rinjani, banyak orang menyebut gunung ini sebagai salah satu gunung tercantik di Indonesia. Dengan tinggi 3.726 mdpl, Gunung Rinjani adalah gunung berapi tertinggi kedua di Indonesia. Bagi orang Bali sendiri, gunung ini termasuk dalam jajaran tiga gunung yang disucikan setelah Gunung Semeru dan Gunung Agung.";
        toBaca();
    }

    public void pulaukomodoClick(View view) {
        this.gambar = R.drawable.pulaukomodokepulauannusatenggara;
        this.judul = "Pulau Komodo (Kepulauan Nusa Tenggara)";
        this.oleh = "Misaka Mikoto";
        this.paragraph ="Jika Anda ingin menikmati the real habitat dari hewan khas Indonesia, di sinilah lokasi yang tepat. Pulau Komodo sendiri terdiri dari beberapa pulau dan perairan laut. Salah satu yang terkenal adalah Taman Nasional Loh Liang yang terletak di Pulau Rinca, Manggarai Barat, Labuan Bajo, Flores. Di sini Anda bisa melihat dari dekat bagaimana kehidupan Komodo sesungguhnya. Pulau Komodo juga masuk sebagai Situs Warisan Dunia UNESCO.";

        this.toBaca();
    }

    public void rajaAmpatClick(View view) {
        this.gambar = R.drawable.rajaampatpapua;
        this.judul = "Kepulauan Raja Ampat (Papua)";
        this.oleh = "Touma";
        this.paragraph ="Kepulauan Raja Ampat adalah destinasi nomor 1 yang wajib Anda kunjungi sebelum memutuskan untuk berlibur ke luar negeri. Mengapa demikian? Kepulauan yang terletak di ujung timur Indonesia ini adalah surga kekayaan bawah laut terlengkap di bumi.";
        this.toBaca();
    }
}
