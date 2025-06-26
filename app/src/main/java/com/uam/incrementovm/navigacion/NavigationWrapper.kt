package com.uam.navegacionobject.navigacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.uam.incrementovm.screen.LoginScreen
import com.uam.navegacionobject.model.User
import com.uam.navegacionobject.screen.DetailScreen
import com.uam.navegacionobject.screen.HomeScreen
import com.uam.navegacionobject.type.generarType
import com.uam.navegacionobject.type.userInfoType
import kotlin.reflect.typeOf


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login>{
            LoginScreen()
        }
        composable<ListUser>{backStackEntry ->
          Detail(){navController.navigate(Detail(it))}
        }
        composable<Detail>(typeMap = mapOf(typeOf<User>() to generarType<User>()))
        { backStackEntry ->
            val detail : Detail = backStackEntry.toRoute()
            DetailScreen(detail.user)
        }
    }
}