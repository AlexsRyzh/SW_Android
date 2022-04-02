package com.example.sw_android

import android.graphics.Paint
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.sw_android.ui.theme.RobotoFontFamily

@Composable
fun RegistrationSrean() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_reg),
            contentDescription = "Главная картинка",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxHeight()
        ) {
            Denimination()
            Buttons()
        }
    }
}

@Composable
private fun Denimination(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth()
            .padding(top = 200.dp)
    ) {
        Text(
            text = "Space",
            color = Color(0xFF3723AF),
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 70.sp,
        )
        Text(
            text = "Work",
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3723AF),
            fontSize = 70.sp,
        )
    }

}

@Composable
private fun Buttons(){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                bottom = 60.dp
            )
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Button_registr(
            nameButton = "регистрация через email",
            Color(0xFF3C90DE),
            R.drawable.icon_registration,
            {}
        )
        Button_registr(
            nameButton = "вход через email",
            Color(0xFFE53F1B),
            R.drawable.sing_in,
            {}
        )
    }

}

@Composable
private fun Button_registr(
    nameButton: String,
    color: Color,
    idImage: Int,
    action: () -> Unit
) {
    TextButton(
        onClick = { action },
        colors = ButtonDefaults.textButtonColors(backgroundColor = color),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(
                bottom = 13.dp,
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 5.dp,
                    end = 10.dp,
                    bottom = 5.dp
                )
                .width(260.dp)
        ) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = nameButton,
                modifier = Modifier
                    .padding(
                        end = 14.dp,
                    )
                    .size(24.dp)
            )

            Text(
                text = nameButton.uppercase(),
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 800, heightDp = 1000)
@Composable
fun PreviewRefistration() {
    RegistrationSrean()
}