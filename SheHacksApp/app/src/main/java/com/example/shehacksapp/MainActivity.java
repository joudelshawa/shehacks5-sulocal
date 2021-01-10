package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shehacksapp.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private Button getStartedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedButton = findViewById(R.id.continueButton);
        getStartedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });
    }

    public void openLoginPage(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}