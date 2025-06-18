package com.uam.incrementovm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL : String = "http://localhost:8181/api/"

object RetrofitInstance {
    val api: LoginApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginApi::class.java)
    }
}