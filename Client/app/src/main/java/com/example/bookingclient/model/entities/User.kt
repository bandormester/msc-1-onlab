package com.example.bookingclient.model.entities

data class User(
    val id: Long?,
    val userName: String,
    val email: String,
    val fullName: String,
    val password: String)