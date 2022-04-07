package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        Button button = (Button) findViewById(R.id.button); // Pirmas muziejus
        Button button9 = (Button) findViewById(R.id.button9); // Antras muziejus

        username = findViewById(R.id.username);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMuseum("Lietuvos aviacijos muziejus");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMuseum("Vytauto Didžiojo karo muziejus");
            }
        });

        Intent intent = getIntent();

        if (intent.getExtras() != null){
            String passedUsername = intent.getStringExtra("data");
            username.setText("Sveiki, "+ passedUsername);
        }
    }
    public void openMuseum(String museum){
        Intent intent = new Intent(this, Museum.class ).putExtra("museum", museum);
        startActivity(intent);
    }


}