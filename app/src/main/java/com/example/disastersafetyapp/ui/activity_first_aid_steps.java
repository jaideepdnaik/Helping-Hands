package com.example.disastersafetyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.disastersafetyapp.R;

public class activity_first_aid_steps extends AppCompatActivity {

    Button crpBtn, chokingBtn, burnsBtn, bleedingBtn, nosebleedsBtn, fractureBtn, heatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_steps);

        crpBtn = findViewById(R.id.crp);
        chokingBtn = findViewById(R.id.choking);
        burnsBtn = findViewById(R.id.burns);
        bleedingBtn = findViewById(R.id.bleeding);
        nosebleedsBtn = findViewById(R.id.nosebleeds);
        fractureBtn = findViewById(R.id.fracture);
        heatBtn = findViewById(R.id.heatexhaustion);

        crpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_crp_steps.class));
            }
        });
        chokingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_choking_steps.class));
            }
        });
        burnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_burns_steps.class));
            }
        });
        bleedingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_bleeding_steps.class));
            }
        });
        nosebleedsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_nosebleeds_steps.class));
            }
        });
        fractureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_fracture_steps.class));
            }
        });
        heatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_first_aid_steps.this, activity_heatstroke_steps.class));
            }
        });
    }
}