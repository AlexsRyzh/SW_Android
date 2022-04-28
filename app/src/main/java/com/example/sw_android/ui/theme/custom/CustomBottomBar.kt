package com.example.sw_android.ui.theme.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomBottomBar(
    usualText: String,
    clickText: String,
    event: (()->Unit)? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(
                vertical = 20.dp
            )
            .fillMaxWidth()
    ) {
        Text(
            text = usualText,
            color = Color(0xFF142B6F)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = clickText,
            color = Color(0xFF142B6F),
            modifier = Modifier
                .clickable(onClick = event?:{})
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
private fun PreviewCustomBottomBar(){
    CustomBottomBar(
        usualText = "Нет аккаунта?",
        clickText = "Зарегистрироваться"
    )
}