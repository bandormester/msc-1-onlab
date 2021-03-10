package com.example.bookingclient.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bookingclient.model.entities.User
import com.example.bookingclient.model.repository.RegisterRepositry
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets

class RegisterViewModel (
    private val registerRepository: RegisterRepositry
) : ViewModel() {
    val registrationStatus: LiveData<Boolean> = registerRepository.getStatus()

    fun register(fullname : String, username : String, email : String, password : String){
        val codedPassword = password//TODO Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString()

        registerRepository.register(User(null, username, email, fullname, codedPassword))
    }
}