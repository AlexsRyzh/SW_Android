package com.example.sw_android.singin_page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.example.sw_android.ui.custom.CustomBottomBar
import com.example.sw_android.ui.custom.CustomTextField
import com.example.sw_android.ui.theme.RobotoFontFamily

@Composable
fun SingInScreen(){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var checkedState by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xffC0B8D0))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .widthIn(max = 400.dp)
                    .padding(horizontal = 20.dp)
            ){
                Text(
                    text = "Вход",
                    fontSize = 42.sp,
                    color = Color(0xff1A22ED),
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(30.dp))
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
                Spacer(modifier = Modifier.height(15.dp))
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
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Checkbox(
                            checked = checkedState ,
                            onCheckedChange = {checkedState = it},
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.White,
                                uncheckedColor = Color.Transparent,
                                checkmarkColor = Color(0xff1A22ED)
                            ),
                            modifier = Modifier
                                .size(22.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xff1A22ED),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .background(Color.White, shape = RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Запомнить пароль",
                            color = Color(0xff1A22ED),
                            fontSize = 14.sp
                        )
                    }
                    Text(
                        text = "Забыли пароль!",
                        color = Color(0xffFF0000),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .clickable {  }
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color(0xff1A22ED)
                    ),
                    shape = RoundedCornerShape(15.dp),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Войти",
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }
        }
        CustomBottomBar(
            firstText = "Нет аккаунта?",
            secondText = "Зарегистрироваться"
        )
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PreviewSingInScreen(){
    SingInScreen()
}


