package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface myapi {



    @POST("signup.php")
    Call<model> adddata(@Query("name") String name, @Query("email") String email, @Query("username") String username, @Query("password") String password);

}
