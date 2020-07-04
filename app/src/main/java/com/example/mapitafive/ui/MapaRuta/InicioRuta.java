package com.example.mapitafive.ui.MapaRuta;

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
import com.example.mapitafive.ui.MapaGPS.MapitaGPS;
import com.example.mapitafive.ui.Marcador;

public class InicioRuta extends Fragment {

    private InicioRutaViewModel mViewModel;
    Button botonRuta;
    EditText latOrigen, lonOrigen, latDestino, lonDestino;
    Marcador marcador1, marcador2;


    public static InicioRuta newInstance() {
        return new InicioRuta();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inicio_ruta_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioRutaViewModel.class);
        botonRuta = getView().findViewById(R.id.boton_ruta);
        latOrigen = getView().findViewById(R.id.lat_origen);
        lonOrigen = getView().findViewById(R.id.lon_origen);
        latDestino = getView().findViewById(R.id.lat_destino);
        lonDestino = getView().findViewById(R.id.lon_destino);
        botonRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lorearMapita();
            }
        });

        // TODO: Use the ViewModel
    }

    private void lorearMapita(){
        marcador1 = new Marcador(Double.parseDouble(latOrigen.getText().toString()), Double.parseDouble(lonOrigen.getText().toString()));
        marcador2 = new Marcador(Double.parseDouble(latDestino.getText().toString()), Double.parseDouble(lonDestino.getText().toString()));
        Intent i = new Intent(getActivity(), MapitaRuta.class);
        MapitaGPS.setMarcador1(marcador1);
        MapitaGPS.setMarcador2(marcador2);
        startActivity(i);

    }

}
