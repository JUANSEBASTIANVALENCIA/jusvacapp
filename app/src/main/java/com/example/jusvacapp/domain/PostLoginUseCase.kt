package com.example.jusvacapp.domain

import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.repository.LoginRepository

class PostLoginUseCase {
    private val loginRepository = LoginRepository()
    suspend operator fun invoke(loginDTO: LoginDTO): DataResponseModel<UserModel> {
        return loginRepository.login(loginDTO)
    }
}