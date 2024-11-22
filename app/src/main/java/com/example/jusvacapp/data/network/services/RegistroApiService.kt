package com.example.jusvacapp.data.network.services

import android.util.Log
import com.example.jusvacapp.core.RetrofitHelper
import com.example.jusvacapp.data.dto.RegistroDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.network.clients.RegistroApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class RegistroApiService {
    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    suspend fun registro(registroDTO: RegistroDTO): DataResponseModel<UserModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RegistroApiClient::class.java).registro(registroDTO)
            Log.e("Registro DTO: ", registroDTO.toString())
            Log.e("Body response: ", response.body().toString())
            response.body()!!
        }
    }
}