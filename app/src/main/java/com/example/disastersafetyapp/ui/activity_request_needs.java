package com.example.disastersafetyapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.disastersafetyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class activity_request_needs extends AppCompatActivity {

    private EditText enterNameEditText, enterLocationEditText;
    private Button requestButton;
    private CheckBox sanitationHygieneCheckBox, shelterCheckBox, foodWaterCheckBox,
            medicalAssistanceCheckBox, financialSupportCheckBox, counsellingTherapyCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_needs);


        enterNameEditText = findViewById(R.id.entername);
        enterLocationEditText = findViewById(R.id.enterlocation);
        requestButton = findViewById(R.id.requestbutton);
        sanitationHygieneCheckBox = findViewById(R.id.sanitationhygiene);
        shelterCheckBox = findViewById(R.id.shelter);
        foodWaterCheckBox = findViewById(R.id.foodwater);
        medicalAssistanceCheckBox = findViewById(R.id.medicalassistance);
        financialSupportCheckBox = findViewById(R.id.financialsupport);
        counsellingTherapyCheckBox = findViewById(R.id.counsellingtherapy);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = enterNameEditText.getText().toString();
                String location = enterLocationEditText.getText().toString();

                Map<String, Object> data = new HashMap<>();
                data.put("name", name);
                data.put("location", location);


                String sanitationHygieneValue = String.valueOf(sanitationHygieneCheckBox.isChecked());
                String shelterValue = String.valueOf(shelterCheckBox.isChecked());
                String foodWaterValue = String.valueOf(foodWaterCheckBox.isChecked());
                String medicalAssistanceValue = String.valueOf(medicalAssistanceCheckBox.isChecked());
                String financialSupportValue = String.valueOf(financialSupportCheckBox.isChecked());
                String counsellingTherapyValue = String.valueOf(counsellingTherapyCheckBox.isChecked());

                data.put("sanitationHygiene", sanitationHygieneValue);
                data.put("shelter", shelterValue);
                data.put("foodWater", foodWaterValue);
                data.put("medicalAssistance", medicalAssistanceValue);
                data.put("financialSupport", financialSupportValue);
                data.put("counsellingTherapy", counsellingTherapyValue);

                // Create a Firestore document reference
                DocumentReference documentRef = FirebaseFirestore.getInstance().collection("needs").document();

                // Set the data to the Firestore document
                documentRef.set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(activity_request_needs.this, "Successfully Requested", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(activity_request_needs.this, "Your Needs Request has been submitted", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}