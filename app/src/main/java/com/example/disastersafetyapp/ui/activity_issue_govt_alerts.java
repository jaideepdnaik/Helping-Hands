package com.example.disastersafetyapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.disastersafetyapp.R;

public class activity_issue_govt_alerts extends AppCompatActivity {

    Button issueAlert, earthquakeSensor, checkForNeeds, disaster;
    TextView createNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_govt_alerts);

        issueAlert = findViewById(R.id.issuealert);
        earthquakeSensor = findViewById(R.id.earthquakesensorbtn);
        checkForNeeds = findViewById(R.id.checkforneeds);
        createNewAccount = findViewById(R.id.createnewaccount);
        disaster = findViewById(R.id.disasterinformation);

        issueAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_issue_govt_alerts.this, activity_calamity_alert.class));
            }
        });
        earthquakeSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_issue_govt_alerts.this, activity_earthquake_sensor.class));
            }
        });
        checkForNeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_issue_govt_alerts.this, activity_checking_for_needs.class));
            }
        });
        disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_issue_govt_alerts.this, disaster_info_show.class));
            }
        });
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_issue_govt_alerts.this, activity_register.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        showLogoutConfirmationDialog();
    }

    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to log out?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Perform logout operation
                        logout();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Dismiss the dialog and continue
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    private void logout() {
        // Perform logout operation
        // For example, redirect to the login screen
        startActivity(new Intent(activity_issue_govt_alerts.this, MainActivity.class));
        finish(); // Finish the current activity
    }
}