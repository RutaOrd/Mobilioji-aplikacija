package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Museum extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum1);
        button1 = (Button) findViewById(R.id.button5);
        button2 = (Button) findViewById(R.id.button3);
        button3 = (Button) findViewById(R.id.button6);
        TextView museumText = findViewById(R.id.textView4);
        museumText.setText(getIntent().getStringExtra("museum"));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExhibitsList();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExhibitScan();
            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }

        });
    }

    public void  openExhibitsList(){
        Intent intent2 = new Intent(this, ExhibitsList.class ).putExtra("museum", getIntent().getStringExtra("museum"));
        startActivity(intent2);
    }
    public void  openExhibitScan(){
        Intent intent3 = new Intent(this, ExhibitScan.class ).putExtra("museum", getIntent().getStringExtra("museum"));
        startActivity(intent3);
    }
    public void  openMainPage(){
        finish();
    }

}