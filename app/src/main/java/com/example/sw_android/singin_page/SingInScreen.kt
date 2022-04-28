package com.example.sw_android.singin_page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.ui.theme.custom.CustomBottomBar
import com.example.sw_android.ui.theme.custom.CustomTextField
import com.example.sw_android.ui.theme.custom.Logo


@Composable
fun SingInScreen(){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF142B6F))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth()
        ){
            Logo(logoSize = 80.dp)
        }
        Column(
            modifier = Modifier
                .weight(9f)
                .widthIn(max = 400.dp)
                .clip(RoundedCornerShape(topStart = 80.dp))
                .background(Color(0xffF6F6F6))
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = 30.dp
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Вход",
                    color = Color(0xFF142B6F),
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = email,
                    onValueChange = {email = it},
                    clearOnClick = {email = ""},
                    label = "Email"
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = password,
                    onValueChange = {password = it},
                    clearOnClick = {password = ""},
                    label = "Пароль"
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xff142B6F),
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(15.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = "Вход",
                            fontSize = 20.sp,
                        )
                    }
                }
            }
            CustomBottomBar(
                usualText = "Нет аккаунта?",
                clickText = "Зарегистрироваться"
            )
        }
    }
}




@Preview(showSystemUi = true)
@Composable
private fun PreviewSingInScreen(){
    SingInScreen()
}