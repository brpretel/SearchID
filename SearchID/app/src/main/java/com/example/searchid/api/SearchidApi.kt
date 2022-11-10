package com.example.searchid.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface SearchidApi {
    @GET("/Documents")
    fun getAllPosts(): Call<List<Documents>>

    @FormUrlEncoded
    @POST("/auth/token")
    fun login(@Field("username") username: String,
              @Field("password") password : String
    ): Call<UserLoginResponse>
}