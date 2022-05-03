package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sw_android.ui_page.main_page.MainScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    mAuth: FirebaseAuth
){
    NavHost(navController = navController, startDestination = if (mAuth.currentUser == null) Screen.WELCOME_GRAPH.route else Screen.MainScreen.route ){
        RegAndSingInNavGraph(navController = navController, mAuth = mAuth)
        composable(
            route = Screen.MainScreen.route
        ){
            MainScreen()
        }
    }
}