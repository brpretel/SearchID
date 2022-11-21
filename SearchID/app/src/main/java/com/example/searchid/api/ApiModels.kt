package com.example.searchid.api

import com.google.gson.annotations.SerializedName

/*Datos que contiene los documentos*/
data class Documents(
    val id: Int,
    val document_type: String,
    val numero_id: String,
    val status: Boolean,
    val owner_id: Int,
)

/*Field Necesarios para el Signup del usuario*/
data class  UserSignup(
    val username: String,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String

)

/*Elementos a usar como header para verificar si el usuario esta en sesion*/
data class UserLoginResponse(
    @SerializedName("user_id") val user_Id: Int,
    val username: String,
    @SerializedName("token")val accesToken: String,

)