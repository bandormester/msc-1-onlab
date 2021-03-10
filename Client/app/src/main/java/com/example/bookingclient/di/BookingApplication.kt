package com.example.bookingclient.di

import android.app.Application

class BookingApplication : Application() {
    val appContainer = AppContainer(this)

    val SHARED_PREFENCES = "bookingAppPreferences"
    val API_KEY = "bookingAppApiKey"
}