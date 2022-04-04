package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Museum1 extends AppCompatActivity {

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExhbitsList();
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExhbitScan();
            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }

        });
    }
    public void  openExhbitsList(){
        Intent intent2 = new Intent(this, ExhibitsList.class );
        startActivity(intent2);
    }
    public void  openExhbitScan(){
        Intent intent3 = new Intent(this, ExhibitScan.class );
        startActivity(intent3);
    }
    public void  openMainPage(){
        Intent intent4 = new Intent(this, MainPage.class );
        startActivity(intent4);
    }

}