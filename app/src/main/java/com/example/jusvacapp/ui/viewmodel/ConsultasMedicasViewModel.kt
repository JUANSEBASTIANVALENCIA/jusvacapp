package com.example.jusvacapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.domain.DeleteConsultasMedicasUseCase
import com.example.jusvacapp.domain.GetConsultasMedicasUseCase
import com.example.jusvacapp.domain.PostConsultasMedicasUseCase
import com.example.jusvacapp.domain.PutConsultasMedicasUseCase
import kotlinx.coroutines.launch
import kotlin.math.log

class ConsultasMedicasViewModel : ViewModel() {
    val ConsultaMedicaModel = MutableLiveData<DataResponseLocalModel<UserModel>>()
    val userModel = MutableLiveData<UserModel>()
    var isLoading = MutableLiveData<Boolean>()
    var message = MutableLiveData<String>()

    private val getConsultasMedicasUseCase = GetConsultasMedicasUseCase()
    private val postConsultasMedicasUseCase = PostConsultasMedicasUseCase()
    private val putConsultasMedicasUseCase = PutConsultasMedicasUseCase()
    private val deleteConsultasMedicasUseCase = DeleteConsultasMedicasUseCase()

    fun getConsultas() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getConsultasMedicasUseCase()
            when (result.status) {
                "success" -> {
                    Log.e("ConsultaMedicaModel: ", result.data.toString())
                    isLoading.postValue(false)
                }
            }
        }
    }
    fun postConsultas() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = postConsultasMedicasUseCase()
            when (result.status) {
                "success" -> {
                    Log.e("ConsultaMedicaModel: ", result.data.toString())
                    isLoading.postValue(false)
                }
            }
        }
    }

    fun putConsultas() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = putConsultasMedicasUseCase()
            when (result.status) {
              "success" -> {
                  Log.e("ConsultaMedicaModel: ", result.data.toString())
                  isLoading.postValue(false)
              }
            }
        }
    }
    fun deleteConsultas() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = deleteConsultasMedicasUseCase()
            when (result.status) {
                "success" -> {
                    Log.e("ConsultaMedicaModel: ", result.data.toString())
                    isLoading.postValue(false)
                }
            }
        }
    }
}