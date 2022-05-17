package com.example.sw_android

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sw_android.ui_page.auth_screen.registration_page.RegistrationScreen
import com.example.sw_android.ui_page.auth_screen.registration_page.RegistrationViewModel
import com.example.sw_android.ui_page.auth_screen.singin_page.SingInRouter
import com.example.sw_android.ui_page.auth_screen.singin_page.SingInScreen
import com.example.sw_android.ui_page.auth_screen.singin_page.SingInViewModel
import com.example.sw_android.ui_page.auth_screen.welcome_page.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth



fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    mAuth: FirebaseAuth
){
    navigation(
        startDestination =  Screen.Welcome.route,
        route = NavGraph.AuthGraph.route
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
            SingInRouter(
                singInViewModel = singInViewModel,
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