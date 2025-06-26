package com.uam.incrementovm.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uam.incrementovm.model.User


@Composable
fun DetailUser(user:User){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(user.nombre)
        Text(user.apellido)
        Text(user.email)
    }
}