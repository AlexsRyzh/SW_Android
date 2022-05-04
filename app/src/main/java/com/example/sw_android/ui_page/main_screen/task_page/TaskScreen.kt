package com.example.sw_android.ui_page.main_screen.task_page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TaskScreen(
    navController: NavController
){
    Text(text = "Task", fontSize = 40.sp)
}