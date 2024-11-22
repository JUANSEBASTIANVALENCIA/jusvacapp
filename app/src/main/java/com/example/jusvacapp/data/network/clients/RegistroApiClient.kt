package com.example.jusvacapp.data.network.clients

import com.example.jusvacapp.data.dto.RegistroDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistroApiClient {
    @POST("registro") // Cambiar cuando el API este lista segun el endpoint de registro de usuario
    suspend fun registro(@Body registroDTO: RegistroDTO): Response<DataResponseModel<UserModel>>
}