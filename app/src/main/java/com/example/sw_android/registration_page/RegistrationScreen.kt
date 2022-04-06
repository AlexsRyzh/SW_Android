package com.example.sw_android.registration_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.R

@Composable
fun FieldRegistration(
    modifier: Modifier = Modifier,
    idImage: Int
){
    var active by remember {
        mutableStateOf(true)
    }
    var value by remember { mutableStateOf("Имя") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            )
            .border(width = 0.5.dp, color = Color.Black)
    ) {
        Image(
            painter = painterResource(id = idImage),
            contentDescription = "Иконка регистрации",
            modifier = Modifier
                .size(40.dp)
        )
        BasicTextField(
            value = value,
            textStyle = TextStyle(
                fontSize = 20.sp
            ),
            singleLine = true,
            onValueChange = { value = it},
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )
                .width(200.dp)
                .clickable{
                    value = "ffyfyfu"
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FieldRegistrationPreview(){
    FieldRegistration(
        idImage = R.drawable.profile,
    )
}