package com.example.sw_android.ui_page.auth_screen.singin_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sw_android.Screen
import com.example.sw_android.ui.theme.Black2E2E
import com.example.sw_android.ui.theme.custom.CustomBottomBar
import com.example.sw_android.ui.theme.custom.CustomTextField
import com.example.sw_android.ui.theme.custom.Logo


@Composable
fun SingInScreen(
    UiState: SingInViewModel,
    navController: NavController
){
    Box(){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Black2E2E)
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
                        text = UiState._uiState.email,
                        onValueChange = {UiState.onEvent(SingInFormEvent.EmailChanged(it))},
                        clearOnClick = {UiState.onEvent(SingInFormEvent.EmailChanged(""))},
                        label = "Email"
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomTextField(
                        text = UiState._uiState.password,
                        onValueChange = {UiState.onEvent(SingInFormEvent.PasswordChanged(it))},
                        clearOnClick = {UiState.onEvent(SingInFormEvent.PasswordChanged(""))},
                        label = "Пароль",
                        password = true
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    SaveMeAndForgotPassword(
                        UiState = UiState
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = UiState.SingInSuccessful,
                        fontSize = 12.sp,
                        color = Color.Red
                    )
                    TextButton(
                        onClick = {
                            UiState.checkAndSingIn()
                        },
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Black2E2E,
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
                    clickText = "Зарегистрироваться",
                    event = { navController.navigate(Screen.Registration.route)}
                )
            }
        }
        if (UiState.activeProgressBar)
        {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ){
                CircularProgressIndicator(
                    color = Color(0xFF142B6F)
                )
            }
        }
        if (UiState.SingInSuccessful == "Всё верно"){
            navController.navigate(Screen.MainScreen.route)
        }

    }

}


@Composable
fun SaveMeAndForgotPassword(
    UiState: SingInViewModel,
    onClickForgotPassword: (() -> Unit)? = null
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = UiState._uiState.saveMe,
                onCheckedChange = {UiState.onEvent(SingInFormEvent.SaveMeChanged(it))},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xff000000),
                    uncheckedColor = Color(0xff000000),
                    checkmarkColor = Color.White
                ),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Запомнить меня",
                fontSize = 12.sp
            )
        }
        TextButton(
            onClick = onClickForgotPassword?:{}
        ) {
            Text(
                text = "Забыл пароль",
                fontSize = 12.sp,
                color = Color(0xff828282),
                fontFamily = FontFamily.Default
            )
        }

    }
}

