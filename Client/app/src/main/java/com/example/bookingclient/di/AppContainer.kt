package com.example.bookingclient.di

import com.example.bookingclient.di.BookingApplication


class AppContainer (val app : BookingApplication){
    private var loginContainer : LoginContainer? = null

    fun getLoginContainer() : LoginContainer{
        loginContainer = LoginContainer(app)
        return loginContainer!!
    }

    fun releaseLoginContainer(){
        loginContainer = null
    }
}