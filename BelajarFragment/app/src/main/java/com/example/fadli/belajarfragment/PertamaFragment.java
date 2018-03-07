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
public class PertamaFragment extends Fragment {
    TextView tvHasil;
    EditText etPanjang, etLebar;
    Button btHitung;

    public PertamaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pertama, container, false);
        tvHasil = v.findViewById(R.id.hasil);
        etPanjang = v.findViewById(R.id.angkasatu);
        etLebar = v.findViewById(R.id.angkadua);
        btHitung = v.findViewById(R.id.hitung);

        btHitung.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Double panjang = Double.valueOf(etPanjang.getText().toString());
                Double lebar = Double.valueOf(etLebar.getText().toString());
                tvHasil.setText(String.valueOf(panjang * lebar));
            }
        });

        return v;
    }

}
