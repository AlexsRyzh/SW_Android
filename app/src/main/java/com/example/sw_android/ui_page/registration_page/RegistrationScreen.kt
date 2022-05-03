package com.example.sw_android.ui_page.registration_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.Screen
import com.example.sw_android.ui.theme.custom.CustomBottomBar
import com.example.sw_android.ui.theme.custom.CustomTextField
import com.example.sw_android.ui_page.singin_page.SingInFormEvent
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun RegistrationScreen(
    UiState: RegistrationViewModel,
    navController: NavController
){
    val scrollState = rememberScrollState()
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
                    .verticalScroll(scrollState)
            ) {
                CustomTextField(
                    text = UiState.state.name,
                    onValueChange = { UiState.onEvent(RegistrationFormEvent.NameChanged(it)) },
                    clearOnClick = { UiState.onEvent(RegistrationFormEvent.NameChanged("")) },
                    label = "Имя",
                    errorMessages = UiState.state.nameError
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = UiState.state.email,
                    onValueChange = { UiState.onEvent(RegistrationFormEvent.EmailChanged(it)) },
                    clearOnClick = { UiState.onEvent(RegistrationFormEvent.EmailChanged("")) },
                    label = "Email",
                    errorMessages = UiState.state.emailError
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = UiState.state.password,
                    onValueChange = { UiState.onEvent(RegistrationFormEvent.PasswordChanged(it))},
                    clearOnClick = { UiState.onEvent(RegistrationFormEvent.PasswordChanged(""))},
                    label = "Пароль",
                    errorMessages = UiState.state.passwordError
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    text = UiState.state.repeatedPassword,
                    onValueChange = { UiState.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(it))},
                    clearOnClick = { UiState.onEvent(RegistrationFormEvent.RepeatedPasswordChanged("")) },
                    label = "Повторите пароль",
                    errorMessages = UiState.state.repeatedPasswordError
                )
                Spacer(modifier = Modifier.height(15.dp))
                acceptedTermBar(UiState = UiState)
                Spacer(modifier = Modifier.height(15.dp))
                if (UiState.regSuccessful != ""){
                    Text(
                        text = UiState.regSuccessful,
                        color = Color.Red
                    )
                }
                TextButton(
                    onClick = {
                        if (UiState.checkState()){
                            navController.navigate(Screen.MainScreen.route)
                        } },
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
            CustomBottomBar(
                usualText = "Есть аккаунт?",
                clickText = "Войти",
                event = {navController.navigate(Screen.SingIn.route)}
            )
        }
    }
}

@Composable
fun acceptedTermBar(
    UiState: RegistrationViewModel
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Checkbox(
            checked = UiState.state.acceptedTerms,
            onCheckedChange = {UiState.onEvent(RegistrationFormEvent.AcceptedTermsChanged(it))},
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xff000000),
                uncheckedColor = Color(0xff000000),
                checkmarkColor = Color.White
            ),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "Я принимаю условия пользовательского соглашения")
    }
}
