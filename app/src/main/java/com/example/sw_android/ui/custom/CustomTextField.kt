package com.example.sw_android.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit) ? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
){
    OutlinedTextField(
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedLabelColor = Color(0xff1A22ED),
            unfocusedLabelColor = Color(0xff1A22ED),
            cursorColor = Color(0xff1A22ED),
            trailingIconColor = Color.Black,
            leadingIconColor = Color.Black
        ),
        singleLine = true,
        modifier = modifier
            .border(3.dp, Color(0xff1A22ED), RoundedCornerShape(18.dp))
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(18.dp)),
    )
}

@Preview
@Composable
private fun CustomTextFieldPreview(){
    CustomTextField(
        modifier = Modifier,
        value = "CustomTextField" ,
        onValueChange = {},
    )
}