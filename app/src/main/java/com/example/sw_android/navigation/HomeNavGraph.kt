package com.example.sw_android

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sw_android.ui_page.main_screen.add_new_task_page.AddNewTaskScreen
import com.example.sw_android.ui_page.main_screen.main_page.MainScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.MainScreen.route,
        route = NavGraph.MainGraph.route
    ){
        composable(
            route = Screen.MainScreen.route
        ){
            MainScreen(
                navController = navController
            )
        }

    }
}