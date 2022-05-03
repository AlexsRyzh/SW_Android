package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sw_android.ui_page.registration_page.RegistrationScreen
import com.example.sw_android.ui_page.registration_page.RegistrationViewModel
import com.example.sw_android.ui_page.singin_page.SingInScreen
import com.example.sw_android.ui_page.singin_page.SingInViewModel
import com.example.sw_android.ui_page.welcome_page.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth



fun NavGraphBuilder.RegAndSingInNavGraph(
    navController: NavController,
    mAuth: FirebaseAuth
){
    navigation(
        startDestination =  Screen.Welcome.route,
        route = Screen.WELCOME_GRAPH.route
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