package com.example.sw_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.lang.reflect.Modifier

@Composable
fun MainViev(){
    nav(name = "Задачи")
}

@Composable
fun nav(name: String){
    Row {
       Button(onClick = { /*TODO*/ },
       modifier = Modifier
           .background(Color())) {
           
       }
        Column(modifier = Modifier
            .) {
            Text(text = name)
            Text(text = "Моё пространство")
        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}