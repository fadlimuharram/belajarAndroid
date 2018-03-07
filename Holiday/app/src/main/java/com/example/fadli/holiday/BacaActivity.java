package com.example.fadli.holiday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BacaActivity extends AppCompatActivity {
    public static String bacaGambar     ="BACAGAMBAR";
    public static String bacaJudul      ="BACAJUDUL";
    public static String bacaOleh       ="BACAOLEH";
    public static String bacaParagraph  ="BACAPARAGRAPH";
    ImageView gambarVW;
    TextView olehTV,paragraphTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca);
        gambarVW = findViewById(R.id.bacaGambar);
        olehTV = findViewById(R.id.bacaDiUpload);
        paragraphTV = findViewById(R.id.bacaParagraph);

        setTitle(getIntent().getStringExtra(BacaActivity.bacaJudul));
        gambarVW.setImageResource(getIntent().getIntExtra(BacaActivity.bacaGambar,0));
        olehTV.setText(getIntent().getStringExtra(BacaActivity.bacaOleh));
        paragraphTV.setText(getIntent().getStringExtra(BacaActivity.bacaParagraph));
    }
}
