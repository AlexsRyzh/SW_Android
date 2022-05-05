package com.example.sw_android.ui_page.main_screen.main_page

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.MainNavGraph

@Composable
fun MainScreen(
    navController: NavController
){
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationGraph(navController = bottomNavController)
            }
    ) {
        MainNavGraph(
            navController = bottomNavController
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview(){
    MainScreen(navController = rememberNavController())
}