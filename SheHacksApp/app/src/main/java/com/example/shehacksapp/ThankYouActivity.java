package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThankYouActivity extends AppCompatActivity {
    private Button back2menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        back2menu = findViewById(R.id.backtomenubutton);

        back2menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }
        });
    }

    private void goToMenu() {
        Intent intent = new Intent(this, menuActivity.class);
        startActivity(intent);
    }
}