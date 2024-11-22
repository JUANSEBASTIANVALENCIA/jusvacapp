package com.example.jusvacapp.domain

import com.example.jusvacapp.data.dto.RegistroDTO
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.repository.RegistroRepository

class PostRegistroUseCase {
    private val registroRepository = RegistroRepository()
    suspend operator fun invoke(registroDTO: RegistroDTO): DataResponseModel<UserModel> {
        return registroRepository.registro(registroDTO)
    }
}