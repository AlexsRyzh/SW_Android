package com.example.sw_android.registration_page


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.ui.custom.CustomTextField
import com.example.sw_android.ui.theme.RobotoFontFamily

@Composable
fun FieldRegistration(){
    var name by remember {
        mutableStateOf("")
    }
    var surname by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .background(Color(0xffC0B8D0))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .widthIn(max = 400.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Регистрация",
                    fontSize = 42.sp,
                    color = Color(0xff1A22ED),
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CustomTextField(
                        modifier = Modifier
                            .weight(1f),
                        value = name,
                        onValueChange = {name = it},
                        placeholder = { Text(text = "Имя", fontSize = 18.sp) },
                        trailingIcon = { if (name!="") Icon(
                            Icons.Outlined.Clear,
                            contentDescription = "Clear",
                            modifier = Modifier
                                .clickable { name = "" }
                                .padding(horizontal = 15.dp)
                        )
                        },
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    CustomTextField(
                        modifier = Modifier
                            .weight(1f),
                        value = surname,
                        onValueChange = {surname = it},
                        placeholder = { Text(text = "Фамилия", fontSize = 18.sp) },
                        trailingIcon = { if (name!="") Icon(
                            Icons.Outlined.Clear,
                            contentDescription = "Clear",
                            modifier = Modifier
                                .clickable { name = "" }
                                .padding(horizontal = 15.dp)
                        )
                        },
                    )
                }
                CustomTextField(
                    modifier = Modifier,
                    value = email,
                    onValueChange = {email = it},
                    placeholder = { Text(text = "Email", fontSize = 18.sp)},
                    leadingIcon = { Icon(
                        Icons.Outlined.Email,
                        contentDescription = "Email",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                end = 15.dp
                            )
                            .size(28.dp)
                    )},
                    trailingIcon = { if (email!="") Icon(
                        Icons.Outlined.Clear,
                        contentDescription = "Clear",
                        modifier = Modifier
                            .clickable { email = "" }
                            .padding(horizontal = 15.dp)
                    )}
                )
                CustomTextField(
                    modifier = Modifier,
                    value = password,
                    onValueChange = {password = it},
                    placeholder = { Text(text = "Пароль", fontSize = 18.sp)},
                    leadingIcon = { Icon(
                        Icons.Filled.Lock,
                        contentDescription = "Email",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                end = 15.dp
                            )
                            .size(28.dp)

                    )},
                    trailingIcon = { if (password!="") Icon(
                        Icons.Outlined.Clear,
                        contentDescription = "Clear",
                        modifier = Modifier
                            .clickable { password = "" }
                            .padding(horizontal = 15.dp)
                    )},
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Text(
                text = "Нет аккаунта?",
                color = Color(0xff1A22ED),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Зарегистрироваться",
                color = Color(0xffDD0909),
                fontSize = 14.sp
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun FieldRegistrationPreview(){
    FieldRegistration()
}