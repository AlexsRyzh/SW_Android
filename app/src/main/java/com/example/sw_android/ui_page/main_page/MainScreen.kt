package com.example.sw_android.ui_page.main_page

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.MainNavGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationGraph(navController = navController)
            }
    ) {
        MainNavGraph(
            navController = navController
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview(){
    MainScreen()
}