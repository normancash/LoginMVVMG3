package com.uam.incrementovm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.incrementovm.model.AuthResult
import com.uam.incrementovm.model.LoginRequest
import com.uam.incrementovm.model.User
import com.uam.incrementovm.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel(){

    private val _loginState = MutableStateFlow<AuthResult>(AuthResult.Idle)
    val loginState : StateFlow<AuthResult> = _loginState

    fun login(username : String, password : String){
        viewModelScope.launch {
            _loginState.value = AuthResult.Loading
            try {
                val response = RetrofitInstance.api
                    .login(LoginRequest(username,password))
                val user = User(response.apellido
                    ,response.email
                    ,response.id
                    ,response.nombre)
                _loginState.value = AuthResult.Success(user)
            }
            catch (e : Exception) {
                _loginState.value = AuthResult.Error("Error ${e.message}")
            }
        }
    }

    fun resetState() {
        _loginState.value = AuthResult.Idle
    }

}