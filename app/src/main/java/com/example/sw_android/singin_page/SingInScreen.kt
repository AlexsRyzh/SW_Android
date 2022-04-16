package com.example.sw_android.singin_page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.ui.theme.Blue300
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffC0B8D0))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .widthIn(max = 400.dp)
                .padding(horizontal = 20.dp)
        ){
            Text(
                text = "Вход",
                fontSize = 48.sp,
                color = Blue300,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp,
                        vertical = 10.dp
                    )
            )
            Spacer(modifier = Modifier)
            CustomTextField(
                modifier = Modifier,
                value = email,
                onValueChange = {email = it},
                placeholeder = { Text(text = "Email")}
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomTextField(
                modifier = Modifier,
                value = password,
                onValueChange = {password = it},
                placeholeder = { Text(text = "Пароль")}
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked =checkedState ,
                        onCheckedChange = {checkedState = it}
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Запомнить пароль",
                        color = Color(0xff3100BC)
                    )
                }
                Text(
                    text = "Забыли пароль!",
                    color = Color(0xffFF0000)
                )
            }
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholeder: @Composable () -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    ){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholeder,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedLabelColor = Color(0xff3100BC),
            unfocusedLabelColor = Color(0xff3100BC),
            cursorColor = Color(0xff3100BC)
        ),
        singleLine = true,
        modifier = modifier
            .border(3.dp, Color(0xff3100BC), RoundedCornerShape(10.dp))
            .fillMaxWidth()
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewSingInScreen(){
    SingInScreen()
}


