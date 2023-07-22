package com.example.disastersafetyapp.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.disastersafetyapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class activity_reportingimage extends AppCompatActivity {
    Button back, selectphoto, uploadbtn;
    ImageView imageView;
    EditText name, desc;
    String title, descrption;
    ProgressDialog progressDialog;
    Uri imguri;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    final private StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Reported_Info");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportingimage);

        imageView = findViewById(R.id.imageView);
        uploadbtn = findViewById(R.id.upload);

        name = findViewById(R.id.title);
        desc = findViewById(R.id.desc);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {

                    Intent data = result.getData();
                    imguri = data.getData();
                    imageView.setImageURI(imguri);
                } else {
                    Toast.makeText(activity_reportingimage.this, "No photo selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent();
                photoPicker.setAction(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });
        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imguri != null) {
                    progressDialog = new ProgressDialog(activity_reportingimage.this);
                    progressDialog.setCancelable(false);
                    progressDialog.setMessage("Uploading...");
                    progressDialog.show();
                    uploadtofirebase(imguri);
                } else {
                    Toast.makeText(activity_reportingimage.this, "No photo selected", Toast.LENGTH_SHORT).show();
                }
            }
        });


        back = findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void uploadtofirebase(Uri imguri) {

        title = name.getText().toString();
        descrption = desc.getText().toString();


        final StorageReference imageReference = storageReference.child(System.currentTimeMillis() + "." + getfileextracted(imguri));
        imageReference.putFile(imguri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String image_uri = uri.toString();
                        Map<String, Object> venue = new HashMap<>();
                        venue.put("name", title);
                        venue.put("img_url", image_uri);
                        venue.put("desc", descrption);
                        db.collection("venues").document(title)
                                .set(venue)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        if (progressDialog.isShowing())
                                            progressDialog.dismiss();
                                        Toast.makeText(activity_reportingimage.this, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show();
                                        name.setText("");
                                        desc.setText("");
                                        imageView.setImageDrawable(null);

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        if (progressDialog.isShowing())
                                            progressDialog.dismiss();
                                        Toast.makeText(activity_reportingimage.this, "Failed", Toast.LENGTH_SHORT).show();

                                    }
                                });
                        Intent intent = new Intent(activity_reportingimage.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity_reportingimage.this, "failed", Toast.LENGTH_SHORT).show();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });
    }

    private String getfileextracted(Uri fireuri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(fireuri));
    }

}