package com.example.shehacksapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class FoodActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<LatLng> foods = new ArrayList<LatLng>();
    private ArrayList<String> names = new ArrayList<String>();
    private Button continueB;

    String name1 = "Rasa Indonesia by Petojo Food & Catering";
    LatLng loc1 = new LatLng(43.019208,-81.217061);
    String name2 = "The Whole Grain Hearth";
    LatLng loc2 = new LatLng(42.96177,-81.214618);
    String name3 = "Plant Matter Kitchen";
    LatLng loc3 = new LatLng(42.969487,-81.216308);
    String name4 = "The Piping Kettle Soup Co.";
    LatLng loc4 = new LatLng(43.019928,-81.215803);
    String name5 = "The Squire Pub & Grill";
    LatLng loc5 = new LatLng(42.983058,-81.251453);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        foods.add(loc1);
        foods.add(loc2);
        foods.add(loc3);
        foods.add(loc4);
        foods.add(loc5);

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);

        /*// getting the food and drink section from the excel spreadsheet
        try {
            AssetManager am = getAssets();
            InputStream is = am.open("shehacks_data.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();

            int iFoods = 0;
            for (int i = 0; i < row; i++) {
                Cell c = s.getCell(3,i);
                if (c.toString().equals("Food & Drink")) {
                    foods[iFoods].add(s.getCell(0,i));
                    foods[iFoods].add(s.getCell(1,i));
                    iFoods++;
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }*/


        continueB = findViewById(R.id.continueButton);
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRate();
            }
        });
    }

    private void goToRate() {
        Intent intent = new Intent(this, RateActivity.class);
        startActivity(intent);
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

        for (int i = 0; i < foods.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(foods.get(i)).title(names.get(i)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(20.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(foods.get(i)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(foods.get(0),15));



        /*mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(location).title("Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));*/
    }
}