package com.example.jusvacapp.data.network.services

import android.util.Log
import com.example.jusvacapp.core.RetrofitHelper
import com.example.jusvacapp.core.RetrofitLocalHelper
import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.ConsultaMedicaModel
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.clients.ConsultaMedicaApiClient
import com.example.jusvacapp.data.network.clients.LoginApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class ConsultaMedicaApiService {
    private val retrofit: Retrofit = RetrofitLocalHelper.getRetrofit()
    suspend fun getConsultas(): DataResponseLocalModel<ConsultaMedicaModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ConsultaMedicaApiClient::class.java).getConsultas()
            Log.e("Body response: ",response.body().toString())
            response.body()!!
        }
    }
}