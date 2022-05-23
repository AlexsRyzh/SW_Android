package com.example.sw_android.ui_page.main_screen.analitic_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sw_android.Nav
import com.example.sw_android.NavBot
import com.example.sw_android.NavTop

@Composable
fun AnaliticScreen(
    navController: NavController
){
    Text(text = "Analitic", fontSize = 40.sp)
}



@Preview
@Composable
fun PrewivNavTop() {
    Column(modifier = Modifier.fillMaxHeight()) {

    }
}