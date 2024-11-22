package com.example.jusvacapp.data.repository

import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.ConsultaMedicaModel
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.services.ConsultaMedicaApiService
import com.example.jusvacapp.data.network.services.LoginApiService
import com.example.jusvacapp.data.providers.ConsultaMedicaProvider
import com.example.jusvacapp.data.providers.UserProvider

class ConsultaMedicaRepository {
    private val consultaMedicaApiService = ConsultaMedicaApiService()

    suspend fun getConsultas(): DataResponseLocalModel<ConsultaMedicaModel> {
        val response = consultaMedicaApiService.getConsultas()
        if(response.status == "success"){
            ConsultaMedicaProvider.consultaMedicaList = response.data
        }
        return response
    }
}