package com.example.firebase_lab08;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Touchone extends AppCompatActivity {
    DatabaseReference mData;
    ImageView imageView1,imageView2,imageView3;
    ArrayList<UserFace> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_please_touch_one);

        arrayList = new ArrayList<>();
        mData = FirebaseDatabase.getInstance().getReference();
        imageView1 = findViewById(R.id.imagesHappy);
        imageView2 = findViewById(R.id.imagesNormal);
        imageView3 = findViewById(R.id.imagesSad);

        mData.child("user").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                UserFace userFace = snapshot.getValue(UserFace.class);
                userFace.setKey(snapshot.getKey());
                arrayList.add(userFace);
                Toast.makeText(Touchone.this, snapshot.getKey(), Toast.LENGTH_SHORT).show();
                Toast.makeText(Touchone.this, userFace.getUserMail(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String userMail = intent.getStringExtra("userMail");
                Toast.makeText(Touchone.this, userMail, Toast.LENGTH_SHORT).show();
                if(arrayList != null){
                    for (UserFace userFace: arrayList) {
                        if(userFace.getUserMail().equalsIgnoreCase(userMail)){
                            userFace.setHappy(userFace.getHappy()+1);
                            Toast.makeText(Touchone.this, "Happy: "+String.valueOf(userFace.getHappy()+1), Toast.LENGTH_SHORT).show();
                            mData.child("user").child(userFace.getKey()).setValue(userFace);
                            break;
                        }
                    }
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String userMail = intent.getStringExtra("userMail");
                Toast.makeText(Touchone.this, userMail, Toast.LENGTH_SHORT).show();
                if(arrayList != null){
                    for (UserFace userFace: arrayList) {
                        if(userFace.getUserMail().equalsIgnoreCase(userMail)){
                            userFace.setNormal(userFace.getNormal()+1);
                            Toast.makeText(Touchone.this, "Normal: "+(userFace.getHappy()+1), Toast.LENGTH_SHORT).show();
                            mData.child("user").child(userFace.getKey()).setValue(userFace);
                            break;
                        }
                    }
                }
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String userMail = intent.getStringExtra("userMail");
                Toast.makeText(Touchone.this, userMail, Toast.LENGTH_SHORT).show();
                if(arrayList != null){
                    for (UserFace userFace: arrayList) {
                        if(userFace.getUserMail().equalsIgnoreCase(userMail)){
                            userFace.setNoHappy(userFace.getNoHappy()+1);
                            Toast.makeText(Touchone.this, "No Happy: "+(userFace.getHappy()+1), Toast.LENGTH_SHORT).show();
                            mData.child("user").child(userFace.getKey()).setValue(userFace);
                            break;
                        }
                    }
                }
            }
        });
    }
}