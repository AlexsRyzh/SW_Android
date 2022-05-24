package com.example.sw_android.ui.theme.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    text: String,
    onValueChange: (String) -> Unit,
    clearOnClick: ()->Unit,
    label: String,
    standText: String = "alexsandr.ryzhkov0232@mail.ru",
    errorMessages: String? = null,
    password: Boolean = false
){
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = 2000.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xffFFFFFF))
                .padding(
                    start = 25.dp,
                    top = 15.dp,
                    end = 25.dp,
                    bottom = 20.dp
                )
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = label,
                    fontSize = 16.sp,
                    color = Color.Black,
                )
                Box(modifier = Modifier ){
                    BasicTextField(
                        value = text,
                        visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = if (password) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
                        onValueChange = onValueChange,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color(0xff828282),
                            fontSize = 14.sp,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    if (text==""){
                        Text(
                            text = standText,
                            fontSize = 14.sp,
                            color = Color(0xff828282)
                        )
                    }
                }
                if (errorMessages != null){
                    Text(
                        text = errorMessages,
                        color = Color.Red,
                        fontSize = 14.sp
                    )
                }


            }
            if (text!=""){
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Кнопка очистки",
                    tint = Color(0xff828282),
                    modifier = Modifier
                        .size(25.dp)
                        .clickable(onClick = clearOnClick)
                )
            }

        }
    }
}

@Preview(backgroundColor = 0xffffff)
@Composable
fun CustomTextFieldPreview(){
    CustomTextField(
        text = "Preview" ,
        onValueChange = {},
        clearOnClick = { /*TODO*/ },
        label = "Hellow")
}