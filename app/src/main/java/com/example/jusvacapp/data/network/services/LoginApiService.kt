package com.example.jusvacapp.data.network.services

import android.util.Log
import com.example.jusvacapp.core.RetrofitHelper
import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.clients.LoginApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class LoginApiService {
    private val retrofit:Retrofit = RetrofitHelper.getRetrofit()

    suspend fun login(loginDTO: LoginDTO): DataResponseModel<UserModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginApiClient::class.java).login(loginDTO)
            Log.e("Login DTO: ",loginDTO.toString())
            Log.e("Body response: ",response.body().toString())
            response.body()!!
        }
    }
}