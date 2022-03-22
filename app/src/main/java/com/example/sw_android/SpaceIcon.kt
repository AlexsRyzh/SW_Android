package com.example.sw_android

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SpaceIcon(){
    Canvas(
        modifier = Modifier
            .size(500.dp)
    ){
        drawCircle(
            color = Color.Black,
            radius = 1f,
        )
    }
}

@Preview(showBackground = true, widthDp = 50, heightDp = 50)
@Composable
fun PrewiSpaceIcon(){
    SpaceIcon()
}