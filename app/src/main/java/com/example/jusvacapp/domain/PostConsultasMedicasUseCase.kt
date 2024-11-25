package com.example.jusvacapp.domain

import com.example.jusvacapp.data.model.ConsultaMedicaModel
import com.example.jusvacapp.data.model.DataResponseLocalModel
import com.example.jusvacapp.data.repository.ConsultaMedicaRepository

class PostConsultasMedicasUseCase {
    private val consultaMedicaRepository = ConsultaMedicaRepository()
    suspend operator fun invoke(): DataResponseLocalModel<ConsultaMedicaModel> {
        return consultaMedicaRepository.postConsultas()
    }
}