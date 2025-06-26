package com.uam.incrementovm.network

import androidx.lifecycle.viewmodel.compose.viewModel
import com.uam.incrementovm.repository.LoginRepository
import com.uam.incrementovm.repository.UserRepository

object ServiceLocator {
    private val userApi = RetrofitInstance.userApi
    private val loginApi = RetrofitInstance.loginApi


    val loginRepository by lazy {
        LoginRepository(loginApi)
    }

    val userRepository by lazy {
        UserRepository(userApi)
    }


}