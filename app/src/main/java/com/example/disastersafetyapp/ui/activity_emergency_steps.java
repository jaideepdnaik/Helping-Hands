package com.example.disastersafetyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.disastersafetyapp.R;

public class activity_emergency_steps extends AppCompatActivity {

    Button earthquakeSteps, floodSteps, hurricaneSteps, landslideSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_steps);

        earthquakeSteps = findViewById(R.id.earthquake);
        floodSteps = findViewById(R.id.flood);
        hurricaneSteps = findViewById(R.id.hurricane);
        landslideSteps = findViewById(R.id.landslide);

        earthquakeSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_emergency_steps.this, activity_earthquake_steps.class));
            }
        });
        floodSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_emergency_steps.this, activity_flood_steps.class));
            }
        });
        hurricaneSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_emergency_steps.this, activity_hurricane_steps.class));
            }
        });
        landslideSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_emergency_steps.this, activity_landslide_steps.class));
            }
        });
    }
}