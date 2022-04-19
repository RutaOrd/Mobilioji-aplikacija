package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    Button btn;
    EditText name,uname,email,pwd;
    String url="https://museumapp69.000webhostapp.com/";
    TextView btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = (EditText) findViewById(R.id.name);
        uname = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        btnSignup = findViewById(R.id.loginText);


                btn =(Button) findViewById(R.id.regbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(uname.getText().toString()) || TextUtils.isEmpty(pwd.getText().toString()) || TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(SignUp.this,"All fields Required", Toast.LENGTH_LONG).show();
                }else{
                    //proceed to reg
                    process();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
    }

    public void process(){
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().addData(name.getText().toString(), email.getText().toString(), uname.getText().toString(), pwd.getText().toString());
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(SignUp.this,"Registration Successful", Toast.LENGTH_LONG).show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            startActivity(new Intent(SignUp.this, Login.class));
                        }
                    },700);

                }else{
                    Toast.makeText(SignUp.this,"Reg Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(SignUp.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}