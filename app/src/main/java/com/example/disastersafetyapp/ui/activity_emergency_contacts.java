package com.example.disastersafetyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import com.example.disastersafetyapp.R;

public class activity_emergency_contacts extends AppCompatActivity {

    Button ambulance, police, fire, disaster,nd1,nd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);

        ambulance = findViewById(R.id.ambulancebutton);
        police = findViewById(R.id.policebutton);
        fire = findViewById(R.id.firebutton);
        disaster = findViewById(R.id.disasterbutton);
        nd1 = findViewById(R.id.ndrf1);
        nd2 = findViewById(R.id.ndrf2);

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "108";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data));
                startActivity(intent);
            }
        });
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "100";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data));
                startActivity(intent);
            }
        });
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "101";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data));
                startActivity(intent);
            }
        });
        disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "01124363260";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data));
                startActivity(intent);
            }
        });
        nd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "01123438019";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data));
                startActivity(intent);
            }
        });
        nd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "01123438017";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data));
                startActivity(intent);
            }
        });
    }
}