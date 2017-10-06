package com.example.sudhakar.rfdms_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.sudhakar.rfdms_app.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        sharedPreferences=this.getSharedPreferences("map",MODE_PRIVATE);
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

        // Add a marker in Sydney and move the camera
        LatLng rlard1 = new LatLng(18.559718, 73.791604);
        MarkerOptions markerOptions1=new MarkerOptions().position(rlard1).title("Feeder 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).visible(true);
        Marker feeder1=mMap.addMarker(markerOptions1);
        feeder1.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rlard1));

        LatLng rlard2 = new LatLng(19.559718, 74.791604);
        MarkerOptions markerOptions2=new MarkerOptions().position(rlard2).title("Feeder 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).visible(true);
        Marker feeder2= mMap.addMarker(markerOptions2);
       // feeder2.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rlard2));

        LatLng rlard3 = new LatLng(20.559718, 75.791604);
        MarkerOptions markerOptions3=new MarkerOptions().position(rlard3).title("Feeder 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).visible(true);
        Marker feeder3=mMap.addMarker(markerOptions3);
       // feeder3.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rlard3));

        LatLng rlard4 = new LatLng(22.559718, 77.791604);
        MarkerOptions markerOptions4=new MarkerOptions().position(rlard4).title("Feeder 4").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).visible(true);
        Marker feeder4=mMap.addMarker(markerOptions4);
      //  feeder4.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rlard4));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(rlard1).zoom(6).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        googleMap.setOnMarkerClickListener(this);

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.getTitle().equals("Feeder 1"))
        {

                    Intent intent=new Intent(MapsActivity.this,GridViewActivity.class);
                    startActivity(intent);
        }
        else if(marker.getTitle().equals("Feeder 2"))
        {
            Toast.makeText(MapsActivity.this,marker.getTitle()+" Has Been DeActivated",Toast.LENGTH_LONG).show();

        }
        else if(marker.getTitle().equals("Feeder 3"))
        {

            Toast.makeText(MapsActivity.this,marker.getTitle()+" Has Been DeActivated",Toast.LENGTH_LONG).show();
        }
        else if(marker.getTitle().equals("Feeder 4"))
        {
            Toast.makeText(MapsActivity.this,marker.getTitle()+" Has Been DeActivated",Toast.LENGTH_LONG).show();

        }

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("marker",marker.getTitle());
        editor.commit();

        return true;
    }


    @Override
    public void onBackPressed() {

    }
}
