package com.example.mapitafive.ui.MapaGPS;

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
import com.example.mapitafive.ui.MapaUbicacion.Mapita;
import com.example.mapitafive.ui.Marcador;
import com.google.android.gms.maps.model.LatLng;

public class InicioGPS extends Fragment {

    private InicioGViewModel mViewModel;
    Button botongps;
    EditText ing_lat;
    EditText ing_lon;
    Marcador marcador2;

    public static InicioGPS newInstance() {
        return new InicioGPS();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inicio_g_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioGViewModel.class);
        // TODO: Use the ViewModel
        botongps = getView().findViewById(R.id.boton_gps);
        ing_lat = getView().findViewById(R.id.ingresa_lat);
        ing_lon = getView().findViewById(R.id.ingresa_lon);

        botongps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lorearGPS();

            }
        });
    }

    public void lorearGPS(){
         marcador2 = new Marcador(Double.parseDouble(ing_lat.getText().toString()), Double.parseDouble(ing_lon.getText().toString()));
        Intent i = new Intent(getActivity(), MapitaGPS.class);
        MapitaGPS.setMarcador2(marcador2);
        startActivity(i);

    }




}
