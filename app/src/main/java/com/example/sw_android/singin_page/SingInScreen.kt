package com.example.sw_android.singin_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.Screen
import com.example.sw_android.registration_page.RegistrationFormEvent
import com.example.sw_android.registration_page.RegistrationViewModel
import com.example.sw_android.ui.theme.custom.CustomBottomBar
import com.example.sw_android.ui.theme.custom.CustomTextField
import com.example.sw_android.ui.theme.custom.Logo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun SingInScreen(
    UiState: SingInViewModel,
    navController: NavController
){
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
                    text = UiState._uiState.email,
                    onValueChange = {UiState.onEvent(RegistrationFormEvent.EmailChanged(it))},
                    clearOnClick = {UiState.onEvent(RegistrationFormEvent.EmailChanged(""))},
                    label = "Email"
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = UiState._uiState.password,
                    onValueChange = {UiState.onEvent(RegistrationFormEvent.PasswordChanged(it))},
                    clearOnClick = {UiState.onEvent(RegistrationFormEvent.PasswordChanged(""))},
                    label = "Пароль"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = UiState.SingInSuccessful)
                TextButton(
                    onClick = { UiState.singInAccount() },
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
                clickText = "Зарегистрироваться",
                event = { navController.navigate(Screen.Registration.route)}
            )
        }
    }
}




@Preview(showSystemUi = true)
@Composable
private fun PreviewSingInScreen(){
    SingInScreen(
        UiState = SingInViewModel(Firebase.auth),
        navController = rememberNavController()
    )
}