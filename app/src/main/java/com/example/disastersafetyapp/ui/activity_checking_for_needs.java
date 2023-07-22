package com.example.disastersafetyapp.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.disastersafetyapp.R;
import com.example.disastersafetyapp.adaapter.MyAdapter;
import com.example.disastersafetyapp.models.User;
//import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class activity_checking_for_needs extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore db;
    MyAdapter myAdapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_for_needs);

        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.userList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity_checking_for_needs.this,RecyclerView.VERTICAL,false));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(activity_checking_for_needs.this, list,recyclerView);
        recyclerView.setAdapter(myAdapter);

        db.collection("needs").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("FirestoreListener", "Listen failed: " + error);
                    return;
                }
                if (value != null) {
                    List<User> newVenueList = new ArrayList<>();

                    for (DocumentSnapshot document : value.getDocuments()) {
                        String documentId = document.getId();
                        String counsellingTherapy = document.getString("counsellingTherapy").toString();
                        String financialSupport = document.getString("financialSupport").toString();
                        String foodWater = document.getString("foodWater").toString();
                        String location = document.getString("location").toString();
                        String medicalAssistance = document.getString("medicalAssistance").toString();
                        String name = document.getString("name").toString();
                        String sanitationHygiene = document.getString("sanitationHygiene").toString();
                        String shelter = document.getString("shelter").toString();
                        User user = new User(name,location,shelter,foodWater,medicalAssistance,financialSupport,counsellingTherapy,sanitationHygiene);
                        newVenueList.add(user);
                    }
                    myAdapter.setData(newVenueList);

                }
            }
        });
    }
}