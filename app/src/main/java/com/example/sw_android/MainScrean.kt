package com.example.sw_android

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


@Composable
fun MainViev(){
    Nav(name = "Задачи")
}

@Composable
fun Nav(name: String){
    Row { Button(onClick = { /*TODO*/ }) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawLine(
                start = Offset(x = canvasWidth, y = 0f),
                end = Offset(x = 0f, y = canvasHeight),
                color = Color.Blue
            )
        }
       }
        Column() {
            Text(text = name)
            Text(text = "Моё пространство")
        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}
