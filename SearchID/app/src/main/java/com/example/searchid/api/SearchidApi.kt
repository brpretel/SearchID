package com.example.searchid.api

import retrofit2.Call
import retrofit2.http.*

interface SearchidApi {

    /*Obtenemos los TODOS los documentos en una lista*/
    @GET("/Documents")
    fun getAllPosts(): Call<List<Documents>>

    /*Creacion del token y la sesion si el usuario existe*/
    @FormUrlEncoded
    @POST("/auth/token")
    fun login(@Field("username") username: String,
              @Field("password") password : String
    ): Call<UserLoginResponse>

    /*Crea un usuario*/
    @POST("/auth/create/user")
    fun signup(@Body user: UserSignup): Call<UserSignup>
}