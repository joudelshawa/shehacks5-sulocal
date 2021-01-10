package com.example.shehacksapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shehacksapp.ui.login.LoginActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class VirtualActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<LatLng> virtualLoc = new ArrayList<LatLng>();
    private ArrayList<String> names = new ArrayList<String>();
    private Button continueB;

    String name1 = "Museum of Ontario Archaeology";
    LatLng loc1 = new LatLng(43.013452,-81.305814);
    String name2 = "Modo Yoga London";
    LatLng loc2 = new LatLng(42.992856,-81.252873);
    String name3 = "NutritionRx";
    LatLng loc3 = new LatLng(43.002674,-81.196322);
    String name4 = "The Royal Canadian Regiment Museum";
    LatLng loc4 = new LatLng(43.000546,-81.233621);
    String name5 = "Museum London";
    LatLng loc5 = new LatLng(42.982582,-81.255067);

//    private final ArrayList<LatLng> locations = new ArrayList<LatLng>();
//    private final ArrayList<String> names = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        virtualLoc.add(loc1);
        virtualLoc.add(loc2);
        virtualLoc.add(loc3);
        virtualLoc.add(loc4);
        virtualLoc.add(loc5);

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);

        // getting the misc section from the excel spreadsheet
        /*try {
            AssetManager am = getAssets();
            InputStream is = am.open("shehacks.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int rows = s.getRows();
            double latitude, longitude;

            for (int i = 0; i < rows; i++) {
                names.add(s.getCell(0, i).getContents());
                latitude = Double.parseDouble(s.getCell(1, i).getContents());
                longitude = Double.parseDouble(s.getCell(2, i).getContents());
                locations.add(new LatLng(latitude, longitude));
            }

        } catch (Exception e) {
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
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0; i < virtualLoc.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(virtualLoc.get(i)).title(names.get(i)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(20.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(virtualLoc.get(i)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(virtualLoc.get(0),15));

        /*for (int i = 0; i < names.size(); i++) {
            //LatLng location = new LatLng(locations.get(i).latitude, locations.get(i).longitude);
            googleMap.addMarker(new MarkerOptions()
                    .position(locations.get(i))
                    .title(names.get(i)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(locations.get(i)));
        }*/
    }
}