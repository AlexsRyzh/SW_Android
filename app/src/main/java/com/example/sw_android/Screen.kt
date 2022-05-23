package com.example.sw_android

sealed class Screen(val route: String){

    ///Auth
    object Welcome: Screen(route = "welcome_screen")
    object SingIn: Screen(route = "singin_screen")
    object Registration: Screen(route = "reg_screen")

    ///MainScreen
    object MainScreen: Screen(route = "main_screen")
    object SearchScreen: Screen(route = "search_screen")
    object TaskScreen: Screen(route = "task_screen")
    object AnaliticScreen: Screen(route = "analitic_screen")
    object MenuScreen: Screen(route = "menu_screen")
    object AddNewTaskScreen: Screen(route = "add_new_task_screen")
    object EditTaskScreen: Screen(route = "edit_task_screen")

}

sealed class NavGraph(val route: String){
    object AuthGraph: NavGraph(route = "AUTH_ROUTE")
    object MainGraph: NavGraph(route = "MAIN_ROUTE")
}

