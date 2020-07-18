package com.google.firebase.example.fireeats;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseFirestore.setLoggingEnabled(true);
        createChatter("12345");
    }

    private static void createChatter(final String chatterId) {
        CollectionReference dbUsers = FirebaseFirestore.getInstance().collection("Users");
        Map<String, Object> user = new HashMap<>();
        user.put("email", "abc@xyz.com");
        user.put("name", "First Last");
        user.put("dpUrl", "N/A");
        dbUsers.document(chatterId)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("-- done --");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("-- failed --");
                    }
                });
    }
}
