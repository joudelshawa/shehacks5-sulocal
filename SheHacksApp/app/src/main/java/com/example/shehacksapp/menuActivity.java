package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shehacksapp.ui.login.LoginActivity;

public class menuActivity extends AppCompatActivity {
    private Button foodButton;
    private Button retButton;
    private Button virtButton;
    private Button misButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        foodButton = findViewById(R.id.foodAndDrinksButton);
        foodButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openFoodPage();
            }
        });

        retButton = findViewById(R.id.retailButton);
        retButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openRetailPage();
            }
        });

        virtButton = findViewById(R.id.virtualButton);
        virtButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openVirtualPage();
            }
        });

        misButton = findViewById(R.id.miscButton);
        misButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMiscPage();
            }
        });
    }

    private void openFoodPage() {
       Intent intent = new Intent(this, FoodActivity.class);
       startActivity(intent);
    }

    private void openRetailPage() {
        Intent intent = new Intent(this, RetailActivity.class);
        startActivity(intent);
    }

    private void openVirtualPage() {
        Intent intent = new Intent(this, VirtualActivity.class);
        startActivity(intent);
    }

    private void openMiscPage() {
        Intent intent = new Intent(this, MiscActivity.class);
        startActivity(intent);
    }
}