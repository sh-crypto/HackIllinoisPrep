package com.example.hackillinoisandroidchallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://adonix.hackillinois.org/"

    // Create Retrofit instance lazily
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Explicitly define the API service with the correct type
    val api: EventApiService by lazy {
        retrofit.create(EventApiService::class.java)
    }
}
