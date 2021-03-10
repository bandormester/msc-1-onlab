package com.example.bookingclient.model.repository

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookingclient.di.BookingApplication
import com.example.bookingclient.model.service.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository (
    private val loginService : LoginService,
    private val app : BookingApplication
){
    private val sharedPreferences: SharedPreferences = app.getSharedPreferences(app.SHARED_PREFENCES, MODE_PRIVATE)
    private var token : MutableLiveData<String>? = null

    fun getLastToken() : MutableLiveData<String> {
        token = MutableLiveData()
        token!!.value = ""

       //val apiKey = sharedPreferences.getString(app.TOKEN_KEY, null)
       //val userId = sharedPreferences.getInt(app.USERID_KEY, 0)

       //if (apiKey != null && userId != 0) {
       //    token!!.value = ApiToken(userId, apiKey)
       //}
       return token!!
    }

    fun releaseToken(){
        token = null
    }

    fun tryLogin(username : String, password : String) {
        loginService.tryLogin(username, password).enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    token!!.value = response.body()
                }
                else{
                    token!!.value = "Login failed"
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("retrofit",t.message.toString())
                Log.d("retrofit",t.cause.toString())
                token!!.value = "Unable to connect server"
            }
        })
    }
}