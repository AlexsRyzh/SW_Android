package com.example.sw_android.singin_page

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.ui.theme.Blue300
import com.example.sw_android.ui.theme.RobotoFontFamily

@Composable
fun SingInScreen(){
    var email by remember {
        mutableStateOf("Email")
    }
    var emailFoncusFirst by remember {
        mutableStateOf(true)
    }
    var password by remember {
        mutableStateOf("Пароль")
    }
    var passwordFoncusFirst by remember {
        mutableStateOf(true)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        Text(
            text = "Вход",
            fontSize = 48.sp,
            color = Blue300,
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        Column() {
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier
                    .onFocusEvent { if (emailFoncusFirst){
                        email = ""
                        emailFoncusFirst = false
                    } }
            )
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                Modifier
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PreviewSingInScreen(){
    SingInScreen()
}


