package com.example.bookingclient.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookingclient.model.entities.User
import com.example.bookingclient.model.service.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterRepositry (
    private val loginService : LoginService
){
    private var status : MutableLiveData<Boolean>? = null

    fun getStatus() : MutableLiveData<Boolean> {
        status= MutableLiveData()
        status!!.value = false
        return status!!
    }

    fun releaseStatus() {
        status = null
    }

    fun register(user : User) {
        loginService.register(user).enqueue(object :
            Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    status!!.value = response.body()
                }else{
                    Log.d("Register", response.body().toString())
                    Log.d("Register", response.code().toString())
                }
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d("Register", t.message.toString())
                Log.d("Register", t.cause.toString())
                Log.d("Register", "Failed")
                status!!.value = false
            }
        })
    }
}