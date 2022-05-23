package com.example.sw_android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.firebase.auth.FirebaseAuth

@RequiresApi(Build.VERSION_CODES.O)
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