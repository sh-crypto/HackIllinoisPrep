package com.example.hackillinoisandroidchallenge.repository

import com.example.hackillinoisandroidchallenge.network.RetrofitInstance

class EventRepository {
    suspend fun getEvents() = RetrofitInstance.api.getEvents()
}
