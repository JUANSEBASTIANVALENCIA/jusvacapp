package com.example.jusvacapp.data.model

data class DataResponseModel<TipoGenerico> (
    val status: String,
    val message: String?,
    //val data: List<TipoGenerico>
    val data: TipoGenerico
)
