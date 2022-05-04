package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.firebase.auth.FirebaseAuth

@Composable
fun RootNavGraph(
    navController: NavHostController,
    mAuth: FirebaseAuth
){
    NavHost(navController = navController, startDestination = if (mAuth.currentUser == null) NavGraph.AuthGraph.route else NavGraph.MainGraph.route ){
        authNavGraph(navController = navController, mAuth = mAuth)
        homeNavGraph(navController = navController)
    }
}