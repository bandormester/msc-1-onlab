package com.example.bookingclient.model.repository

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
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
                    if(response.body() != ""){
                        val editor = sharedPreferences.edit()
                        editor.putString(app.API_KEY, response.body()!!)
                        editor.apply()
                    }
                }
                else{
                    token!!.value = "Login failed"
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                token!!.value = "Unable to connect server"
            }
        })
    }
}