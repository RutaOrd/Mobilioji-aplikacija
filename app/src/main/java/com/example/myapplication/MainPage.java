package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    private Button button;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        button = (Button) findViewById(R.id.button);

        username = findViewById(R.id.username);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMuseum1();
            }
        });

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            String passedUsername = intent.getStringExtra("data");
            username.setText("Sveiki, "+passedUsername);
        }

    }
    public void openMuseum1(){
        Intent intent1 = new Intent(this, Museum1.class );
        startActivity(intent1);
    }


}