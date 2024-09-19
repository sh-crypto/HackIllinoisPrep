package com.example.hackillinoisandroidchallenge.network

import com.example.hackillinoisandroidchallenge.model.Event
import retrofit2.http.GET

interface EventApiService {
    @GET("event/")
    suspend fun getEvents(): EventsResponse
}

data class EventsResponse(
    val events: List<Event>
)
