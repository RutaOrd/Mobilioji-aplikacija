package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        username = findViewById(R.id.username);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            String passedUsername = intent.getStringExtra("data");
            username.setText("Sveiki "+passedUsername);
        }
    }
}