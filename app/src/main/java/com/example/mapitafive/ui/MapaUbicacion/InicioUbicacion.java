package com.example.mapitafive.ui.MapaUbicacion;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mapitafive.R;
import com.example.mapitafive.ui.Marcador;

public class InicioUbicacion extends Fragment {

    EditText textLat;
    EditText textLong;
    Button botonBuscar;
    Marcador newMarcador;
    //ArrayList<Marcador> Marcadores;
    View view;

    private InicioUbicacionViewModel mViewModel;

    public static InicioUbicacion newInstance() {
        return new InicioUbicacion();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.inicio_ubicacion_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioUbicacionViewModel.class);
        // TODO: Use the ViewModel
        textLat = view.findViewById(R.id.editTextLat);
        textLong = view.findViewById(R.id.editTextLon);
        botonBuscar = view.findViewById(R.id.boton_lorear);
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lorearMapa();

            }
        });

    }

    public void lorearMapa(){


          newMarcador = new Marcador(Double.parseDouble(textLat.getText().toString()), Double.parseDouble(textLong.getText().toString()));


        Intent i = new Intent(getActivity(), Mapita.class);
       Mapita.setMarcador(newMarcador);
        startActivity(i);

    }


}
