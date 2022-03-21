package com.example.sw_android

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign


@Composable
fun MainViev() {
    Nav(name = "Задачи")
}

@Composable
fun Nav(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Unspecified),
            onClick = { /*TODO*/ },
        ) {

        }

        Column(

        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Моё пространство",
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = { /*TODO*/ }
        ) {

        }

    }
}

@Preview
@Composable
fun PrewivNav() {
    Nav("Android")
}