package com.example.sw_android

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainViev() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Nav(name = "Задачи ")
        Nav2()
    }

}

@Composable
fun Nav(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                start = 25.dp,
                top = 20.dp,
                end = 25.dp,
                bottom = 10.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = { /*TODO*/ },
        ) {

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                fontSize = 20.sp
            )
            Text(
                text = "Моё пространство",
                fontSize = 14.sp
            )
        }
        Button(
            onClick = { /*TODO*/ }
        ) {

        }

    }
}

@Composable
fun Nav2() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                start = 20.dp,
                top = 10.dp,
                end = 20.dp,
                bottom = 10.dp
            )
    ) {
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Cписок",
                color = Color.Black
            )
        }
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Доска",
                color = Color.Black
            )
        }
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Календарь",
                color = Color.Black
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrewivNav() {
    Nav("Android")
}

@Preview(showBackground = true)
@Composable
fun PrewivNav2() {
    Nav2()
}