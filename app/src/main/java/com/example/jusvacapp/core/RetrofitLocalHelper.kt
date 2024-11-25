package com.example.jusvacapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitLocalHelper {
    // Cambiar la ip cada vez que se conecte a un WiFi distinto
    private const val BASE_URL = "http://192.168.1.106/jusvac-api/public/api/"
    //ip de la Universidad 10.10.161.211
    //private const val BASE_URL = "http://10.10.161.211/jusvac-api/public/api/"


    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}