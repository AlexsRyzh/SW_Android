package com.example.sw_android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.ui.theme.Blue100
import com.example.sw_android.ui.theme.Blue200
import com.example.sw_android.ui.theme.Red200
import com.example.sw_android.ui.theme.RobotoFontFamily

@Composable
fun WelcomeScrean(
    navControler: NavHostController
) {
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
            Buttons(navControler = navControler)
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
            color = Blue200,
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 70.sp,
        )
        Text(
            text = "Work",
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            color = Blue200,
            fontSize = 70.sp,
        )
    }

}

@Composable
private fun Buttons(
    navControler: NavHostController
){
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
            Blue100,
            R.drawable.icon_registration,
            action = { }
        )
        Button_registr(
            nameButton = "вход через email",
            Red200,
            R.drawable.sing_in,
            action = {
                navControler.navigate(route = Screen.SingIn.route)
            }
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
        onClick = action,
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


@Preview(showBackground = true, widthDp = 480, heightDp = 1000)
@Composable
fun PreviewBaseScreen() {
    WelcomeScrean(navControler = rememberNavController())
}