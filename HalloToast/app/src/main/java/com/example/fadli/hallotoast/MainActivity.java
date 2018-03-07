package com.example.fadli.hallotoast;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvCount;
    Toast ts;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void countClick(View view) {
        this.count++;
        tvCount = findViewById(R.id.valCount);
        tvCount.setText(String.valueOf(this.count));
    }

    public void toastClick(View view) {
        Context cnx = getApplicationContext();
        String pesan = getString(R.string.label_toast) + String.valueOf(this.count);
        ts = Toast.makeText(cnx,pesan,Toast.LENGTH_LONG);
        ts.show();

    }
}
