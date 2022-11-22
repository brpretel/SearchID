package com.example.searchid.api

import retrofit2.Call
import retrofit2.http.*

interface SearchidApi {

    /*Obtenemos los TODOS los documentos en una lista*/
    @GET("/Documents")
    fun getAllPosts(): Call<List<Documents>>

    @FormUrlEncoded
    /*Post method de login*/
    @POST("/auth/token")
    fun login(@Field("username") username: String,
              @Field("password") password : String
    ): Call<UserLoginResponse>


    /*Crea un usuario*/
    @POST("/auth/create/user")
    fun signup(@Body user: UserSignup): Call<UserSignup>

    /*POST method para los reportes*/
    @POST("/Reports/")
    fun createReport(@Body report:CreateReport,@Header("Authorization") auth: String) : Call<CreateReportResponse>

    /*Obtenemos los TODOS los documentos en una lista*/
    @GET("/Reports")
    fun getAllReports(): Call<List<Reports>>
}