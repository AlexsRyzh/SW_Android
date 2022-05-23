package com.example.sw_android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sw_android.ui_page.auth_screen.singin_page.SingInViewModel
import com.example.sw_android.ui_page.main_screen.add_new_task_page.AddNewTaskScreen
import com.example.sw_android.ui_page.main_screen.add_new_task_page.AddNewTaskViewModel
import com.example.sw_android.ui_page.main_screen.analitic_page.AnaliticScreen
import com.example.sw_android.ui_page.main_screen.menu_page.MenuScreen
import com.example.sw_android.ui_page.main_screen.menu_page.MenuViewModel
import com.example.sw_android.ui_page.main_screen.search_page.SearchScreen
import com.example.sw_android.ui_page.main_screen.task_page.TaskScreen
import com.example.sw_android.ui_page.main_screen.task_page.TaskViewModel
import com.example.sw_android.ui_page.main_screen.task_page.UiStateTaskScreen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavGraph(
    navController: NavHostController,
    navController2: NavController
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
            val taskViewModel: TaskViewModel = remember {
                TaskViewModel(Firebase.auth)
            }
            TaskScreen(
                navController = navController,
                taskFieldViewModel = taskViewModel,
                navController2 = navController2
            )
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


