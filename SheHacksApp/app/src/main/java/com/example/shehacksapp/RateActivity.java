package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        ratingBar = findViewById(R.id.ratingBar);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s+"Star", Toast.LENGTH_SHORT).show();
                backToStart();
            }
        });
    }

    private void backToStart() {
        String welcome = getString(R.string.thanku);
        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
        Intent inte = new Intent(this, ThankYouActivity.class);
        startActivity(inte);
    }

}
