package com.example.jusvacapp.data.model

import com.google.gson.annotations.SerializedName

data class UserModel (
    @SerializedName("identification") val cedula:String,
    @SerializedName("jwt") val jwt:String
)