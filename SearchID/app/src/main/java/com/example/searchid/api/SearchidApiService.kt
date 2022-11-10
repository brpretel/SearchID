package com.example.searchid.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object SearchidApiService {
    const val BASE_URL= "http://10.0.2.2:8000/"

    var api: SearchidApi

    init {
        val okHttpClient = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(logging)


        val gson = GsonBuilder()
            .setLenient()
            .create()

        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client((okHttpClient.build()))
            .build()
            .create(SearchidApi::class.java)
    }
}