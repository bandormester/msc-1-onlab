package com.example.bookingclient.model.service

import com.example.bookingclient.model.entities.User
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @GET("/login")
    fun tryLogin(
        @Query("userName") username : String,
        @Query("password") password : String) : Call<String>

    @POST("/register")
    fun register(
        @Query("userDetails") user : User) : Call<Boolean>
}