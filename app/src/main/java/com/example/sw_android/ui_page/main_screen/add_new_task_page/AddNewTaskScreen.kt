package com.example.sw_android.ui_page.main_screen.add_new_task_page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddNewTaskScreen(
    navController: NavController
){
    Text(text = "AddNewTask", fontSize = 40.sp)
}