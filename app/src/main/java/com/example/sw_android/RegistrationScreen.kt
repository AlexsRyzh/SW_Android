package com.example.sw_android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun RegistrationSrean(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_registration),
            contentDescription = "Главная картинка",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(400.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = "Space",
                fontSize = 60.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Work",
                fontSize = 60.sp
            )
            Image(painter = painterResource(id = R.drawable.logotype), contentDescription = "Иконка входа")
            Button_registrr(nameButton = "регистрация через email",Color(0xFF3C90DE), R.drawable.icon_registration)
            Button_registrr(nameButton = "вход через email",Color(0xFFE53F1B), R.drawable.sing_in)
        }
    }
}

@Composable
fun Button_registrr(nameButton: String, color: Color, idImage: Int){
    TextButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(
                bottom = 20.dp,
            )
            .background(color)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 5.dp,
                    end = 10.dp,
                    bottom = 5.dp
                )
        ) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = nameButton,
                modifier = Modifier
                    .padding(
                        end = 10.dp,
                    )
            )

            Text(
                text = nameButton.uppercase(Locale.getDefault()),
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun PreviewRefistration(){
    RegistrationSrean()
}