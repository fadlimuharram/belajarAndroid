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
public class KetigaFragment extends Fragment {

    TextView tvHasil;
    EditText jari;
    Button btHitung;

    public KetigaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ketiga, container, false);
        tvHasil = v.findViewById(R.id.hasil);
        jari = v.findViewById(R.id.jarijari);
        btHitung = v.findViewById(R.id.hitung);

        btHitung.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Double jari2 = Double.valueOf(jari.getText().toString());
                tvHasil.setText(String.valueOf((22/7)*jari2*jari2));
            }
        });

        return v;
    }

}
