package com.example.jusvacapp.data.network.clients

import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiClient {
    @POST("sign_in")
    suspend fun login(@Body loginDTO: LoginDTO): Response<DataResponseModel<UserModel>>

}