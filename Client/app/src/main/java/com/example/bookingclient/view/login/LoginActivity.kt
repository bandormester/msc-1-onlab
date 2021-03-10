package com.example.bookingclient.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookingclient.di.BookingApplication
import com.example.bookingclient.R
import com.example.bookingclient.di.LoginContainer

class LoginActivity : AppCompatActivity() {
    lateinit var loginContainer : LoginContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment())
                    .commitNow()
        }

        loginContainer = (application as BookingApplication).appContainer.getLoginContainer()
    }

    override fun onDestroy() {
        super.onDestroy()
        (application as BookingApplication).appContainer.releaseLoginContainer()
    }

    fun toRegisterFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegisterFragment()).commit()
    }

    fun backToLogin(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment()).commit()
    }
}