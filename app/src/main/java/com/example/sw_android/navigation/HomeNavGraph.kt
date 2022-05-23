package com.example.sw_android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.sw_android.ui_page.main_screen.add_new_task_page.AddNewTaskScreen
import com.example.sw_android.ui_page.main_screen.add_new_task_page.AddNewTaskViewModel
import com.example.sw_android.ui_page.main_screen.edit_task_page.EditeTaskScreen
import com.example.sw_android.ui_page.main_screen.edit_task_page.EditeTaskViewModel
import com.example.sw_android.ui_page.main_screen.main_page.MainScreen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@RequiresApi(Build.VERSION_CODES.O)
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
        composable(
            route = Screen.AddNewTaskScreen.route
        ){
            val addNewTaskViewModel: AddNewTaskViewModel = remember {
                AddNewTaskViewModel(Firebase.auth)
            }
            AddNewTaskScreen(
                navController = navController,
                addNewTaskViewModel = addNewTaskViewModel
            )
        }
        composable(
            route = Screen.EditTaskScreen.route + "/{taskUid}",
            arguments = listOf(navArgument("taskUid") { type = NavType.StringType })
        ){ backStackEntry ->
            val editeTaskViewModel: EditeTaskViewModel = remember {
                EditeTaskViewModel(Firebase.auth,backStackEntry.arguments?.getString("taskUid")!!)
            }
            EditeTaskScreen(
                navController = navController,
                editeTaskViewModel = editeTaskViewModel
            )
        }

    }
}