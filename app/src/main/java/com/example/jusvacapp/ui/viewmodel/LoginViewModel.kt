package com.example.jusvacapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.domain.GetConsultasMedicasUseCase
import com.example.jusvacapp.domain.PostLoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val loginModel = MutableLiveData<DataResponseModel<UserModel>>()
    val userModel = MutableLiveData<UserModel>()
    var isLoading = MutableLiveData<Boolean>()
    var message = MutableLiveData<String>()

    private val postLoginUseCase = PostLoginUseCase()
    private val getConsultasMedicasUseCase = GetConsultasMedicasUseCase()


    fun login(loginDTO: LoginDTO) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = postLoginUseCase(loginDTO)
            loginModel.postValue(result)
            when (result.status) {
                "success" -> {
                    userModel.postValue(result.data)
                    isLoading.postValue(false)
                }

                "invalid" -> {
                    message.postValue(result.message!!)
                    isLoading.postValue(false)
                }

                "error" -> {
                    message.postValue("Usuario no registrado! \uD83D\uDE14")
                    isLoading.postValue(false)
                }
            }
        }
    }

    //Provicional hasta que se cree el respectivo ViewModel para el Listado de Consultas Medicas
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


}