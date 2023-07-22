package com.example.disastersafetyapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.disastersafetyapp.R;
import com.example.disastersafetyapp.adaapter.MyInfoAdapter;
import com.example.disastersafetyapp.models.Info;
//import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import android.widget.Toast;

public class disaster_info_show extends AppCompatActivity {


    RecyclerView recyclerView;

    FirebaseFirestore db;

    MyInfoAdapter myAdapter;

    ArrayList<Info> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_info_show);


        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.disinfoshow);
        recyclerView.setLayoutManager(new LinearLayoutManager(disaster_info_show.this, RecyclerView.VERTICAL, false));


        list = new ArrayList<>();
        myAdapter = new MyInfoAdapter(disaster_info_show.this, list, recyclerView);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnclickListener(new MyInfoAdapter.OnItemclickListen() {
            @Override
            public void onItemClick(int position) {
                Info item = list.get(position);
                String id = item.getImg_url();
                Query query = db.collection("venues").whereEqualTo("img_url", id);

                query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                db.collection("venues").document(document.getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(disaster_info_show.this, "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                                        list.remove(position);
                                        myAdapter.notifyDataSetChanged();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(disaster_info_show.this, "Error" + e, Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }

                    }
                });
            }
        });

        db.collection("venues").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Info info = document.toObject(Info.class);
                        list.add(info);
                        myAdapter.notifyDataSetChanged();

                    }
                } else {
                    Exception exception = task.getException();
                    if (exception != null) {
                        Toast.makeText(disaster_info_show.this, "Error: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(disaster_info_show.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}