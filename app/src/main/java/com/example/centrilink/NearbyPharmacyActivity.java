package com.example.centrilink;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NearbyPharmacyActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    CardView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_pharmacy);

        back = findViewById(R.id.map_back);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

//    qweqwe

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
        LatLng sydney = new LatLng(14.5505, 121.0468);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Ascott Hotel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));

        int height = 86;
        int width = 60;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.mipmap.tangina);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        MarkerOptions watsons = new MarkerOptions().position(new LatLng(14.550300, 121.044862)).title("Watsons Forbeswood");
        watsons.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mMap.addMarker(watsons);

        MarkerOptions mercurydrug = new MarkerOptions().position(new LatLng(14.554453, 121.047704)).title("Mercury Drug BGC");
        mercurydrug.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mMap.addMarker(mercurydrug);

        MarkerOptions mercurydrugparkway = new MarkerOptions().position(new LatLng(14.551144, 121.055671)).title("Mercury Drug Parkway");
        mercurydrugparkway.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mMap.addMarker(mercurydrugparkway);

        MarkerOptions tgpp = new MarkerOptions().position(new LatLng(14.554885, 121.04404)).title("Watsons BGC");
        tgpp.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mMap.addMarker(tgpp);

        MarkerOptions watso = new MarkerOptions().position(new LatLng(14.555865, 121.044371)).title("The Generics Pharmacy");
        watso.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mMap.addMarker(watso);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
