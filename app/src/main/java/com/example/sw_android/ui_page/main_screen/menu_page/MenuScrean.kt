package com.example.sw_android.ui_page.main_screen.menu_page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(
    navController: NavController
){
    Text(text = "Menu", fontSize = 40.sp)
}