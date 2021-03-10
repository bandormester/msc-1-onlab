package com.example.bookingclient.model.service

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @GET("/user/login")
    fun tryLogin(
        @Query("username") username : String,
        @Query("password") password : String) : Call<String>

    @POST("/user/register")
    fun register(
        @Query("fullname") fullname : String,
        @Query("username") username : String,
        @Query("email") email : String,
        @Query("password") password : String) : Call<Boolean>
}