package com.example.jusvacapp.data.dto

import com.google.gson.annotations.SerializedName;

data class RegistroDTO(
    @SerializedName("nombre") val nombre: String,
    @SerializedName("username") val username: String,
    @SerializedName("cedula") val cedula: String,
    @SerializedName("password") val password: String,
)