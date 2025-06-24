package com.uam.incrementovm.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.incrementovm.model.ListUser
import com.uam.incrementovm.network.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    private val _users = MutableStateFlow<ListUser>(ListUser())
    val users : StateFlow<ListUser> = _users

    private val userRepository = ServiceLocator.userRepository

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            val result = userRepository.getUsers()
            result.onSuccess {
                _users.value = it
            }
        }
    }
}