package com.example.jusvacapp.data.repository

import com.example.jusvacapp.data.dto.RegistroDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.services.RegistroApiService
import com.example.jusvacapp.data.providers.RegistroProvider

class RegistroRepository {
    private val registroApiApiService =RegistroApiService()

    suspend fun registro(registroDTO: RegistroDTO):DataResponseModel<UserModel>{
        val response = registroApiApiService.registro(registroDTO)
        if(response.status == "success"){
            RegistroProvider.registroModel = response.data
        }
        return response
    }
}