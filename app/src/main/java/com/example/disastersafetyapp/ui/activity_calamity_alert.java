package com.example.disastersafetyapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.disastersafetyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;

public class activity_calamity_alert extends AppCompatActivity {

    Button issueAlert;
    EditText calamityName, calamityLocation, calamityDescription;
    FirebaseFirestore firestore;
    DatabaseReference calamityDbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calamity_alert);

        FirebaseMessaging.getInstance().subscribeToTopic("all");

//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            System.out.println("Fetching FCM registration token failed");
//                            return;
//                        }
//
//                        // Get new FCM registration token
//                        String token = task.getResult();
//
//                        // Log and toast
//                        System.out.println("TOKEN :" + token);
//                        Toast.makeText(activity_calamity_alert.this, token, Toast.LENGTH_SHORT).show();
//                    }
//                });

        calamityName = findViewById(R.id.calamityname);
        calamityLocation = findViewById(R.id.calamitylocation);
        //calamityDescription = findViewById(R.id.calamitydescription);
        issueAlert = findViewById(R.id.issuealertbutton);
        firestore = FirebaseFirestore.getInstance();

        issueAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                HashMap<String, String> data = new HashMap<String, String>();
//                data.put("Calamity Name", calamityName.getText().toString());
//                data.put("Calamity Location", calamityLocation.getText().toString());
//                data.put("Calamity Description", calamityDescription.getText().toString());
//
//                CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("Calamity");
//                DocumentReference documentReference = collectionReference.document("QUNxjp6PCL8uLIghUb3L");

                if (!calamityName.getText().toString().isEmpty() && !calamityLocation.getText().toString().isEmpty()) {
                    FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all", calamityName.getText().toString(), calamityLocation.getText().toString(), getApplicationContext(), activity_calamity_alert.this);
                    notificationsSender.SendNotifications();
                    startActivity(new Intent(activity_calamity_alert.this, activity_alert_notification.class));
                }
                else {
                    Toast.makeText(activity_calamity_alert.this, "Enter Details", Toast.LENGTH_SHORT).show();
                }
//                documentReference.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(activity_calamity_alert.this, "Alert Issued!", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(activity_calamity_alert.this, activity_alert_notification.class));
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(activity_calamity_alert.this, "Alert Not Issued!\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });
    }
}
