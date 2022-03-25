package com.example.mobiliojiaplikacija

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.material.textfield.TextInputEditText
import com.vishnusivadas.advanced_httpurlconnection.PutData
import java.util.jar.Manifest


class Signup : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val textInputEditTextname:TextInputEditText = findViewById(R.id.name)
        val textInputEditTextusername:TextInputEditText = findViewById(R.id.username)
        val textInputEditTextpassword:TextInputEditText = findViewById(R.id.password)
        val textInputEditTextemail:TextInputEditText = findViewById(R.id.email)
        val buttonSignup:Button = findViewById(R.id.buttonSignUp)
        val textviewLogin:TextView = findViewById(R.id.loginText)
        val progressBar:ProgressBar = findViewById(R.id.progress)

        Toast.makeText(getApplicationContext(), "OOF", Toast.LENGTH_SHORT).show()

        buttonSignup.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {

                var name:String = textInputEditTextname.getText().toString()
                var username:String = textInputEditTextusername.getText().toString()
                var password:String = textInputEditTextpassword.getText().toString()
                var email:String = textInputEditTextemail.getText().toString()

                if(!name.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {
                    progressBar.setVisibility(View.VISIBLE)
                    val handler = Handler(Looper.getMainLooper())
                    handler.post(Runnable {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        val field = arrayOfNulls<String>(4)
                        field[0] = "name"
                        field[1] = "username"
                        field[2] = "password"
                        field[3] = "email"
                        //Creating array for data
                        val data = arrayOfNulls<String>(4)
                        data[0] = name
                        data[1] = username
                        data[2] = password
                        data[3] = email
                        val putData = PutData(
                            "https://museumapp69.000webhostapp.com/signup.php",
                            "POST",
                            field,
                            data
                        )
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                progressBar.setVisibility(View.GONE)
                                val result = putData.result
                                if(result.equals("Sign Up Success")){

                                    val intent:Intent = Intent(getApplicationContext(), Login::class.java)
                                    startActivity(intent)
                                    finish()

                                }
                                else{

                                }
                            }
                        }
                        //End Write and Read data with URL
                    })
                }


            }
        })

    }
}