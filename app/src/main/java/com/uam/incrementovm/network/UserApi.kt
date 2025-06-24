package com.uam.incrementovm.network

import com.uam.incrementovm.model.ListUser
import com.uam.incrementovm.model.LoginRequest
import com.uam.incrementovm.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @GET("usuario/all")
    suspend fun getAll(): ListUser
}