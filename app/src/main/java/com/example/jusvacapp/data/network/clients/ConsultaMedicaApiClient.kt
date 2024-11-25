package com.example.jusvacapp.data.network.clients

import com.example.jusvacapp.data.model.ConsultaMedicaModel
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.model.DataResponseModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ConsultaMedicaApiClient {
    @GET("consulta_medica")
    suspend fun getConsultas(): Response<DataResponseLocalModel<ConsultaMedicaModel>>

    @POST("consulta_medica")
    suspend fun postConsultas(): Response<DataResponseLocalModel<ConsultaMedicaModel>>

    @PUT("consulta_medica")
    suspend fun putConsultas(): Response<DataResponseLocalModel<ConsultaMedicaModel>>

    @DELETE("consulta_medica")
    suspend fun deleteConsultas(): Response<DataResponseLocalModel<ConsultaMedicaModel>>
}