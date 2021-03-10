package com.example.bookingclient.di

import com.example.bookingclient.di.factories.RegisterViewModelFactory
import com.example.bookingclient.model.repository.LoginRepository
import com.example.bookingclient.model.repository.RegisterRepositry
import com.example.bookingclient.model.service.LoginService
import com.example.bookingclient.viewmodel.LoginViewModel
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class LoginContainer(app: BookingApplication) {

    private val gson = GsonBuilder().setLenient().create()

    private val loginService =
        Retrofit.Builder().baseUrl("http://84.0.25.32:8080")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(LoginService::class.java)

    private val loginRepository = LoginRepository(loginService, app)

    private val registerRepository = RegisterRepositry(loginService)

    val loginViewModel = LoginViewModel(loginRepository)

    val registerViewModelFactory = RegisterViewModelFactory(registerRepository)
}