package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination =  Screen.Welcome.route
    ){
        composable(
            route = Screen.Welcome.route
        ){

        }
        composable(
            route = Screen.SingIn.route
        ){
        }
        composable(
            route = Screen.Registration.route
        ){
        }
    }
}