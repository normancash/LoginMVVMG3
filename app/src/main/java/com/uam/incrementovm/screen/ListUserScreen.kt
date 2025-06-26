package com.uam.incrementovm.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
//import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uam.incrementovm.model.User
import com.uam.incrementovm.viewmodel.UserViewModel

@Composable
fun ListUserScreen(onNext:(User)->Unit)
{
    val viewModel : UserViewModel = viewModel()
    val state = viewModel.users.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(30.dp)
    )
    {
        items(state.value) { user ->
            Card(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                onClick = {onNext(user)}
            ){
                Text("${user.nombre} ${user.apellido}")
                Text("${user.email}")
            }

        }
    }
}