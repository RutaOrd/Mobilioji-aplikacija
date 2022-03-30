package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SignUp extends AppCompatActivity {
    Button btn;
    EditText name,uname,email,pwd;
    String url="https://museumapp69.000webhostapp.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = (EditText) findViewById(R.id.name);
        uname = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);

        btn =(Button) findViewById(R.id.regbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process();
            }
        });
    }

    public void process(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myapi api = retrofit.create(myapi.class);

        Call<model> call = api.adddata(name.getText().toString(),email.getText().toString(),uname.getText().toString(),pwd.getText().toString());


        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {

                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}