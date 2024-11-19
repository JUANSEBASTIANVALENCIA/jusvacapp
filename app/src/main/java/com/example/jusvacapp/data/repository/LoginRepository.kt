package com.example.jusvacapp.data.repository

import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.services.LoginApiService
import com.example.jusvacapp.data.providers.UserProvider

class LoginRepository {
    private val loginApiService = LoginApiService()

    suspend fun login(loginDTO: LoginDTO):DataResponseModel<UserModel>{
        val response = loginApiService.login(loginDTO)
        if(response.status == "success"){
            UserProvider.userModel = response.data
        }
        return response
    }
}