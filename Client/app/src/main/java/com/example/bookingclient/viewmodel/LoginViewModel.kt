package com.example.bookingclient.viewmodel

import androidx.lifecycle.*
import com.example.bookingclient.model.repository.LoginRepository
import java.nio.charset.StandardCharsets

class LoginViewModel (
    private val loginRepository: LoginRepository
) : ViewModel() {
    val token : MutableLiveData<String> = loginRepository.getLastToken()

    fun tryLogin(username : String, password : String) {
        val encPassword = password //TODO Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString()
        loginRepository.tryLogin(username, encPassword)
    }

}