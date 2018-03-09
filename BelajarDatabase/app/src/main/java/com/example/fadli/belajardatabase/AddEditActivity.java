package com.example.fadli.belajardatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;

public class AddEditActivity extends AppCompatActivity {

    TextView tvName, tvPriority;
    MyDatabase db;

    Boolean edit =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvName = findViewById(R.id.ltEnterName);
        tvPriority = findViewById(R.id.ltEnterPriority);

        if (getIntent() != null){
            if (getIntent().getIntExtra(TodoListAdapter.EDITITEMID,0) != 0) {
                tvName.setText(String.valueOf(getIntent().getStringExtra(TodoListAdapter.EDITITEMNAME)));
                tvPriority.setText(String.valueOf(getIntent().getIntExtra(TodoListAdapter.EDITITEMPRIORITY, 0)));
                edit = true;
            }
        }

        db = new MyDatabase(AddEditActivity.this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tvName.getText().toString();
                int prio = Integer.parseInt(tvPriority.getText().toString());

                if (edit){
                    Item item = new Item(getIntent().getIntExtra(TodoListAdapter.EDITITEMID,0),name,prio);
                    db.updateItem(item);
                }else{
                    Item item = new Item(name,prio);
                    db.addItem(item);

                }
                Intent intent = new Intent(AddEditActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
