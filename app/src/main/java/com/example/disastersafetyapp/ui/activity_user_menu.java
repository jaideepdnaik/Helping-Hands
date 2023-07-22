package com.example.disastersafetyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.disastersafetyapp.R;

public class activity_user_menu extends AppCompatActivity {

    Button earthquakeSensor, reportDisaster, requestNeeds, emergencySteps, firstAidSteps, emergencyContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        earthquakeSensor = findViewById(R.id.earthquakesensor);
        reportDisaster = findViewById(R.id.reportdisaster);
        requestNeeds = findViewById(R.id.requestneeds);
        emergencySteps = findViewById(R.id.emergencysteps);
        firstAidSteps = findViewById(R.id.firstaidsteps);
        emergencyContacts = findViewById(R.id.emergencycontacts);

        earthquakeSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_user_menu.this, activity_earthquake_sensor.class));
            }
        });
        reportDisaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_user_menu.this, activity_reportingimage.class));
            }
        });
        requestNeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_user_menu.this, activity_request_needs.class));
            }
        });
        emergencySteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_user_menu.this, activity_emergency_steps.class));
            }
        });
        firstAidSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_user_menu.this, activity_first_aid_steps.class));
            }
        });
        emergencyContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_user_menu.this, activity_emergency_contacts.class));
            }
        });
    }
}