package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sw_android.ui_page.main_screen.add_new_task_page.AddNewTaskScreen
import com.example.sw_android.ui_page.main_screen.analitic_page.AnaliticScreen
import com.example.sw_android.ui_page.main_screen.menu_page.MenuScreen
import com.example.sw_android.ui_page.main_screen.search_page.SearchScreen
import com.example.sw_android.ui_page.main_screen.task_page.TaskScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = Screen.SearchScreen.route){
        composable(
            route = Screen.SearchScreen.route
        ){
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.TaskScreen.route
        ){
            TaskScreen(navController = navController)
        }
        composable(
            route = Screen.AddNewTaskScreen.route
        ){
            AddNewTaskScreen(navController = navController)
        }
        composable(
            route = Screen.AnaliticScreen.route
        ){
            AnaliticScreen(navController = navController)
        }
        composable(
            route = Screen.MenuScreen.route
        ){
            MenuScreen(navController = navController)
        }
    }
}