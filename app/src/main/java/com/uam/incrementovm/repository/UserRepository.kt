package com.uam.incrementovm.repository

import com.uam.incrementovm.model.ListUser
import com.uam.incrementovm.model.User
import com.uam.incrementovm.network.UserApi

class UserRepository(private val api : UserApi) {

    suspend fun getUsers():Result<ListUser> {
        return try {
                Result.success(api.getAll())
            }
            catch (e: Exception){
                Result.failure(e)
            }
    }

}