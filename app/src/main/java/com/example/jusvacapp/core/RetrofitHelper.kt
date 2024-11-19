package com.example.jusvacapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://autonomia.educarenemociones.com/api/"
    //private const val BASE_URL = "http://192.168.20.21/vanesa/silvopastoril-back/public/api/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}