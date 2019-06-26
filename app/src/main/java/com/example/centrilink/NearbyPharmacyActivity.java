package com.example.centrilink;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NearbyPharmacyActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap, watsonsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_pharmacy);
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
        watsonsMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(14.5505, 121.0468);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Ascott Hotel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng watsons = new LatLng(14.550300, 121.044862);
//        mMap.addMarker(new MarkerOptions().position(watsons).title("Watsons Forbeswood"));
        MarkerOptions marker = new MarkerOptions().position(new LatLng(14.550300, 121.044862)).title("Watsons Forbeswood");
//        marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker_icon)));
//        marker.icon(BitmapDescriptorFactory.fromResource())
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
