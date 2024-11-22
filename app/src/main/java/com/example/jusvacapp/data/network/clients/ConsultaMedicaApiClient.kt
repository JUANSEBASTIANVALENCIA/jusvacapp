package com.example.jusvacapp.data.network.clients

import com.example.jusvacapp.data.model.ConsultaMedicaModel
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.model.DataResponseModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ConsultaMedicaApiClient {
    @GET("consulta_medica")
    suspend fun getConsultas(): Response<DataResponseLocalModel<ConsultaMedicaModel>>

}