package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sw_android.singin_page.SingInScreen


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
            WelcomeScrean(navControler = navController)
        }
        composable(
            route = Screen.SingIn.route
        ){
            SingInScreen()
        }
    }
}