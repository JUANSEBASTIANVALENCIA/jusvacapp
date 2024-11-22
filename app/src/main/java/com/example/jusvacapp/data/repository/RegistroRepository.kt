package com.example.jusvacapp.data.repository

import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.dto.RegistroDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.RegistroModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.services.LoginApiService
import com.example.jusvacapp.data.network.services.RegistroApiService
import com.example.jusvacapp.data.providers.RegistroProvider
import com.example.jusvacapp.data.providers.UserProvider

class RegistroRepository {
    private val RegistroApiApiService =RegistroApiService()

    suspend fun Registro(RegistroDTO: RegistroDTO):DataResponseModel<RegistroModel>{
        val response = RegistroApiApiService.Registro(RegistroDTO)
        if(response.status == "success"){
            RegistroProvider.RegistroModel = response.data
        }
        return response
    }
}