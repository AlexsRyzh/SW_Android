package com.example.sw_android

sealed class Screen(val route: String) {
    object Welcome: Screen(route = "welcome_screen")
    object SingIn: Screen(route = "singin_screen")
    object Registration: Screen(route = "reg_screen")

    object WELCOME_GRAPH: Screen(route = "WELCOME_ROUTE")
    object MAIN_GRAPH: Screen(route = "MAIN_ROUTE")
    ///MainScreen
    object MainScreen: Screen(route = "main_screen")
    object SearchScreen: Screen(route = "search_screen")
    object TaskScreen: Screen(route = "task_screen")
    object AnaliticScreen: Screen(route = "analitic_screen")
    object MenuScreen: Screen(route = "menu_screen")
    object AddNewTaskScreen: Screen(route = "add_new_task_screen")
}

