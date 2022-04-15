package com.example.sw_android

sealed class Screen(val route: String) {
    object Welcome: Screen(route = "home_screen")
    object SingIn: Screen(route = "detail_screen")
}

