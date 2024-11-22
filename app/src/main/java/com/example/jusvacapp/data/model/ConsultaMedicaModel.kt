package com.example.jusvacapp.data.model

import com.google.gson.annotations.SerializedName

data class ConsultaMedicaModel(
    @SerializedName("id") val id:String,
    @SerializedName("nombre_paciente") val nombrePaciente:String,
    @SerializedName("ubicacion") val ubicacion:String,
    @SerializedName("telefono") val telefono:String,
    @SerializedName("sintomas_paciente") val sintomasPaciente:String,
    @SerializedName("fecha_consulta") val fechaConsulta:String,
    @SerializedName("hora_consulta") val horaConsulta:String,
)
