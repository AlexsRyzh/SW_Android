package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sw_android.registration_page.RegistrationScreen
import com.example.sw_android.registration_page.RegistrationViewModel
import com.example.sw_android.singin_page.SingInScreen
import com.example.sw_android.singin_page.SingInViewModel
import com.example.sw_android.welcome_page.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth


@Composable
fun SetupNavGraph(
    navController: NavHostController,
    mAuth: FirebaseAuth
){
    NavHost(
        navController = navController,
        startDestination =  Screen.Welcome.route,
    ){
        composable(
            route = Screen.Welcome.route
        ){
            WelcomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.SingIn.route
        ){
            val singInViewModel = SingInViewModel(mAuth)
            SingInScreen(
                UiState = singInViewModel,
                navController = navController
            )
        }
        composable(
            route = Screen.Registration.route
        ){
            val registrationViewModel = RegistrationViewModel(mAuth)
            RegistrationScreen(
                UiState = registrationViewModel,
                navController = navController
            )
        }
    }
}