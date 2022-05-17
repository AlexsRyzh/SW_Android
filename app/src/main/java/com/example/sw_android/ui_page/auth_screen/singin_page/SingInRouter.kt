package com.example.sw_android.ui_page.auth_screen.singin_page

import androidx.compose.runtime.*
import androidx.navigation.NavController


@Composable
fun SingInRouter(
    singInViewModel: SingInViewModel,
    navController: NavController
){
    SingInScreen(
        UiState = singInViewModel,
        navController = navController,
    )
}