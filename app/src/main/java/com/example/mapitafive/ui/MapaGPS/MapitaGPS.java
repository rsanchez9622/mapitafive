package com.example.mapitafive.ui.MapaGPS;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import com.example.mapitafive.R;
import com.example.mapitafive.ui.Marcador;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.security.acl.Permission;

public class MapitaGPS extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static Marcador marcador1, marcador2;
    private static final int PERMISSIONS_FINE_LOCATION =99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapita_g_p_s);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        aquiToy();
        agregarMarcador2(marcador2);
        //TrazarRuta(marcador1.getLatitud(), marcador1.getLongitud(), marcador2.getLatitud(), marcador2.getLongitud());


    }

    private void agregarMarcador(Marcador nmarcador) {
        LatLng coordenadas = new LatLng(nmarcador.getLatitud(), nmarcador.getLongitud());
        mMap.addMarker(new MarkerOptions().position(coordenadas));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas));
    }

    private void agregarMarcador2(Marcador Nmarcador) {
        LatLng coordenadas2 = new LatLng(Nmarcador.getLatitud(), Nmarcador.getLongitud());
        mMap.addMarker(new MarkerOptions().position(coordenadas2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas2));
    }

    private void actualizarUbicacion(Location plocation) {
        if (plocation != null) {
            marcador1 = new Marcador(plocation.getLatitude(), plocation.getLongitude());
            marcador2 = new Marcador(plocation.getLatitude(), plocation.getLongitude());
            //agregarMarcador(marcador1);


        }
        agregarMarcador(marcador1);

    }

    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void aquiToy() {
        FusedLocationProviderClient flp = LocationServices.getFusedLocationProviderClient(MapitaGPS.this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
              //  requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
            //}
        }
        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 0, listener);
    }

    private void TrazarRuta(LatLng punt1 , LatLng punt2){
        Polyline polyline1 = mMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(punt1.latitude,punt1.longitude),
                        new LatLng(punt2.latitude,punt2.longitude)));
    }

    public static void setMarcador1(Marcador s_marcador1){
        marcador1 = s_marcador1;

    }

    public static void setMarcador2(Marcador s_marcador2){
        marcador2 = s_marcador2;

    }


}
