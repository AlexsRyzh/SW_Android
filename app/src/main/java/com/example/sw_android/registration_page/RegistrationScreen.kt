package com.example.sw_android.registration_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.ui.theme.custom.CustomBottomBar
import com.example.sw_android.ui.theme.custom.CustomTextField


@Composable
fun RegistrationScreen(){
    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordAgain by remember {
        mutableStateOf("")
    }
    var surName by remember {
        mutableStateOf("")
    }
    var email by remember {
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
                .weight(2f)
                .fillMaxWidth()
        ) {
            Text(
                text = "Регистрация",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier
            )
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
                modifier = Modifier
                    .weight(1f)
            ) {
                CustomTextField(
                    text = name,
                    onValueChange = { name = it},
                    clearOnClick = { name = "" },
                    label = "Имя"
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = surName,
                    onValueChange = { surName = it},
                    clearOnClick = { surName = "" },
                    label = "Фамилия"
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = password,
                    onValueChange = { password = it},
                    clearOnClick = { password = "" },
                    label = "Пароль"
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = passwordAgain,
                    onValueChange = { passwordAgain = it},
                    clearOnClick = { passwordAgain = "" },
                    label = "Повторите пароль"
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
                            text = "Регистрация",
                            fontSize = 20.sp,
                        )
                    }
                }
            }
            CustomBottomBar(usualText = "Есть аккаунт?", clickText = "Войти")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RegistrationScreenPreview(){
    RegistrationScreen()
}