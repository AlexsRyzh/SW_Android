package com.example.sw_android.ui.theme.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Logo(
    logoSize: Dp
){
    val roundDp: Dp = 15.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(logoSize)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    bottomEnd = 30.dp
                )
            )
            .background(Color(0xFFF5FAFA))

    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(0.5f)
                .clip(
                    RoundedCornerShape(
                        topStart = roundDp,
                        topEnd = roundDp,
                        bottomEnd = roundDp
                    )
                )
                .background(Color(0xFF142B6F))
        ) {
            Image(
                imageVector = Icons.Filled.Done,
                contentDescription = "Logo",
                colorFilter = ColorFilter.tint(Color(0xFFF5FAFA)),
                modifier = Modifier
                    .fillMaxSize(0.8f)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLogo(){
    Logo(logoSize = 100.dp)
}