package com.example.bookingclient.di.factories

import com.example.bookingclient.model.repository.RegisterRepositry
import com.example.bookingclient.viewmodel.RegisterViewModel

class RegisterViewModelFactory(private val registerRepository: RegisterRepositry) {
    fun create(): RegisterViewModel {
        return RegisterViewModel(registerRepository)
    }
}