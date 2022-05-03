package com.example.sw_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sw_android.ui_page.add_new_task_page.AddNewTaskScreen
import com.example.sw_android.ui_page.analitic_page.AnaliticScreen
import com.example.sw_android.ui_page.menu_page.MenuScreen
import com.example.sw_android.ui_page.registration_page.RegistrationScreen
import com.example.sw_android.ui_page.registration_page.RegistrationViewModel
import com.example.sw_android.ui_page.search_page.SearchScreen
import com.example.sw_android.ui_page.singin_page.SingInScreen
import com.example.sw_android.ui_page.singin_page.SingInViewModel
import com.example.sw_android.ui_page.task_page.TaskScreen
import com.example.sw_android.ui_page.welcome_page.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun MainNavGraph(
    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = Screen.SearchScreen.route){
        composable(
            route = Screen.SearchScreen.route
        ){
            SearchScreen()
        }
        composable(
            route = Screen.TaskScreen.route
        ){
            TaskScreen()
        }
        composable(
            route = Screen.AddNewTaskScreen.route
        ){
            AddNewTaskScreen()
        }
        composable(
            route = Screen.AnaliticScreen.route
        ){
            AnaliticScreen()
        }
        composable(
            route = Screen.MenuScreen.route
        ){
            MenuScreen()
        }
    }
}