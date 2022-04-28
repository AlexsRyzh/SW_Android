package com.example.sw_android

sealed class Screen(val route: String) {
    object Welcome: Screen(route = "welcome_screen")
    object SingIn: Screen(route = "singin_screen")
    object Registration: Screen(route = "reg_screen")
}

