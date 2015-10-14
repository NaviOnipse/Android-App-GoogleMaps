package com.example.jorge.androidappmaps;

import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    //Variables
    private  Location loc;
    private Marker marker;
    private GoogleMap googleMap;
    private CameraPosition cameraPosition;
    private LocationManager locationManager;
    private  FragmentManager myFragmentManager;
    private SupportMapFragment mySupportMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getGooglePlayServices();

        myFragmentManager = getSupportFragmentManager();
        mySupportMapFragment = (SupportMapFragment) myFragmentManager.findFragmentById(R.id.Mapa);
        googleMap = mySupportMapFragment.getMap();


        if (googleMap != null) {
            //Tipo de mapa
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            //Ubicacion actual activada
            googleMap.setMyLocationEnabled(true);
            //Obtener mi ubicacion actual
            getLocation();
        }

    }

    private void getLocation(){
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc != null) {
            showLocationActual(loc.getLatitude(), loc.getLongitude());
        }
    }

    //Marcador de localizacion
    private void showLocationActual(double lat, double lng) {
        LatLng Ubicacion = new LatLng(lat,lng);
        marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat,lng))
                .title("Tu")
                .snippet("Ubicación actual")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        marker.showInfoWindow();

        /*Atributos de camara (vista)*/
        cameraPosition = new CameraPosition.Builder()
                .target(Ubicacion)      // Sets the center of the map to Mountain View
                .zoom(15)                   // Sets the zoom
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    //Servicios de Google Play
    public void getGooglePlayServices(){
        int codigoGooglePlay = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (codigoGooglePlay != ConnectionResult.SUCCESS) {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(codigoGooglePlay, this, 6);
            if (dialog != null) {
                dialog.show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Error al verificar Google Play Servivces",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}
