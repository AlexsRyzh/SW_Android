package com.example.sw_android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationSrean(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_reg),
            contentDescription = "Главная картинка",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(400.dp)
                .fillMaxHeight()
                .width(300.dp)
        ) {
            Text(
                text = "Space",
                color = Color(0xFF2E2084),
                fontSize = 60.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Work",
                color = Color(0xFF2E2084),
                fontSize = 60.sp
            )
            Image(painter = painterResource(id = R.drawable.logotype), contentDescription = "Иконка входа")
            Button_registr(nameButton = "регистрация через email",Color(0xFF3C90DE),
                R.drawable.icon_registration
            )
            Button_registr(nameButton = "вход через email",Color(0xFFE53F1B), R.drawable.sing_in)
        }
    }
}

@Composable
fun Button_registr(nameButton: String, color: Color, idImage: Int){
    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.textButtonColors(backgroundColor = color),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(
                bottom = 13.dp,
            )
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
                .width(260.dp)
        ) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = nameButton,
                modifier = Modifier
                    .padding(
                        end = 14.dp,
                    )
                    .size(24.dp)
            )

            Text(
                text = nameButton.uppercase(),
                fontSize = 14.sp,
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