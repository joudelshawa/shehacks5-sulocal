package com.example.shehacksapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

public class RetailActivity extends FragmentActivity implements OnMapReadyCallback {

    private Button continueB;

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    ArrayList<String> name = new ArrayList<String>();

    String name1 = "Campfire Apparel";
    LatLng loc1 = new LatLng(42.994497,-81.224986);

    String name2 = "Needs and Wants";
    LatLng loc2 = new LatLng(42.989534,-81.251087);

    String name3 = "Outspokin Cycles";
    LatLng loc3 = new LatLng(42.978091,-81.199075);

    String name4 = "Mchardy Vacuum";
    LatLng loc4 = new LatLng(43.004491,-81.30551);

    String name5 = "Birdie’s Nest";
    LatLng loc5 = new LatLng(42.988309,-81.168979);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retail);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(loc1);
        arrayList.add(loc2);
        arrayList.add(loc3);
        arrayList.add(loc4);
        arrayList.add(loc5);

        name.add(name1);
        name.add(name2);
        name.add(name3);
        name.add(name4);
        name.add(name5);



        // getting the retail section from the excel spreadsheet
        /*try {
            AssetManager am = getAssets();
            InputStream is = am.open("shehacks_data.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();

            int iRetail = 0;
            for (int i = 0; i < row; i++) {
                Cell c = s.getCell(3,i);
                if (c.toString().equals("Retail")) {
                    retails[iRetail].add(s.getCell(0,i));
                    retails[iRetail].add(s.getCell(1,i));
                    iRetail++;
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
        for(int i = 0; i <arrayList.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(name.get(i)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(20.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arrayList.get(0),15));
    }
}