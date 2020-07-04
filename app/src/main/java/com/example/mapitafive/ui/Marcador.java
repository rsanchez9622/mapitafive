package com.example.mapitafive.ui;

import com.google.android.gms.maps.model.LatLng;

public class Marcador {
    public static double latitud;
    public static double longitud;

    public Marcador (double mLatitud, double mLongitud){
        latitud = mLatitud;
        longitud = mLongitud;

    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public static void setLatitud(double latitud) {
        Marcador.latitud = latitud;
    }

    public static void setLongitud(double longitud) {
        Marcador.longitud = longitud;
    }
}
