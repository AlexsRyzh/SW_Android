package com.example.sw_android.ui_page.main_screen.main_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            BottomNavigationGraph(
                navController = bottomNavController,
            )
            },
    ) {
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())){
            MainNavGraph(
                navController = bottomNavController
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview(){
    MainScreen(navController = rememberNavController())
}