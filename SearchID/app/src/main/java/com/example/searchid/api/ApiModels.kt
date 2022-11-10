package com.example.searchid.api

import com.google.gson.annotations.SerializedName

data class Documents(
    val id: Int,
    val document_type: String,
    val numero_id: String,
    val status: Boolean,
    val owner_id: Int,
)
data class  User(
    val id: Int,
    val email: String,
    val username: String,
    val first_name: String,
    val last_name: String,
    val hashed_password: String

)

data class UserLoginResponse(
    @SerializedName("user_id") val user_Id: Int,
    val username: String,
    @SerializedName("token")val accesToken: String,
)