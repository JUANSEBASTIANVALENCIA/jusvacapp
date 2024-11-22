package com.example.jusvacapp.data.dto

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.time.LocalTime

data class ConsultaMedicaDTO(
    @SerializedName("nombre") val nombre: String,
    @SerializedName("ubicacion") val ubicacion: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("sintomas") val sintomas: String,
    @SerializedName("fecha") val fecha: LocalDate,
    @SerializedName("hora") val hora: LocalTime,
)