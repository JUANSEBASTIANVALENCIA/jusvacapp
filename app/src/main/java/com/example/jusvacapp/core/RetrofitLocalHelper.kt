package com.example.jusvacapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitLocalHelper {
    // Cambiar la ip cada vez que se conecte a un WiFi distinto
    private const val BASE_URL = "http://10.10.161.3/jusvac-api/public/api/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}