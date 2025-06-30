package com.uam.incrementovm.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uam.incrementovm.model.User
import com.uam.incrementovm.model.UserState
import com.uam.incrementovm.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListUserScreen(onNext:(User)->Unit)
{
    val viewModel : UserViewModel = viewModel()
    val state by viewModel.users.collectAsState()

    val colors = listOf(Color(0xFFBBDEFB),
                Color(0xFFC8E6C9),
                Color(0xFFFFF9C4),
                 Color(0xFFFFCCBC))
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Usuarios") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Usuario")
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (val s = state) {
                is UserState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UserState.Error -> {
                    Text(
                        text = s.message,
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Red
                    )
                }
                is UserState.Success -> {
                    val users = s.users
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        itemsIndexed(users) { index, user ->
                            val bgColor = colors[index % colors.size]
                            Card(
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                modifier = Modifier.fillMaxWidth().clickable {
                                    onNext(user)
                                },
                                colors = CardDefaults.cardColors(containerColor = bgColor)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(text = user.nombre, style = MaterialTheme.typography.titleMedium)
                                    Text(text = user.email, style = MaterialTheme.typography.bodySmall)
                                }
                            }
                        }
                    }
                }
                else -> {}
            }
        }
    }
}