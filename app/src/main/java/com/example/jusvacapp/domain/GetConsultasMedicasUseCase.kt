package com.example.jusvacapp.domain

import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.model.ConsultaMedicaModel
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.model.DataResponseModel
import com.example.jusvacapp.data.model.UserModel
import com.example.jusvacapp.data.repository.ConsultaMedicaRepository
import com.example.jusvacapp.data.repository.LoginRepository

class GetConsultasMedicasUseCase {
    private val consultaMedicaRepository = ConsultaMedicaRepository()
    suspend operator fun invoke(): DataResponseLocalModel<ConsultaMedicaModel> {
        return consultaMedicaRepository.getConsultas()
    }
}