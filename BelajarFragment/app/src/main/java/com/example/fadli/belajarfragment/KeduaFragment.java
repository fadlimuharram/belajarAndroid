package com.example.fadli.belajarfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class KeduaFragment extends Fragment {
    TextView tvHasil;
    EditText etAlas, etTinggi;
    Button btHitung;

    public KeduaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kedua, container, false);

        tvHasil = v.findViewById(R.id.hasilsegitiga);
        etAlas = v.findViewById(R.id.alas);
        etTinggi = v.findViewById(R.id.tinggi);
        btHitung = v.findViewById(R.id.hitungsegitiga);

        btHitung.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Double alas = Double.valueOf(etAlas.getText().toString());
                Double tinggi = Double.valueOf(etTinggi.getText().toString());
                tvHasil.setText(String.valueOf(0.5* alas * tinggi));
            }
        });

        return v;
    }

}
