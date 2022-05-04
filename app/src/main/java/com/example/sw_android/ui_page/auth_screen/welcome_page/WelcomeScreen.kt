package com.example.sw_android.ui_page.auth_screen.welcome_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.Screen
import com.example.sw_android.ui.theme.custom.Logo

@Composable
fun WelcomeScreen(
    navController: NavController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF142B6F))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(6f)
                .fillMaxWidth()
        ) {
            Logo(
                logoSize = 130.dp
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(4f)
                .widthIn(max = 350.dp)
                .padding(horizontal = 20.dp)
        ) {
            CustomBottom(
                text = "регистрация через email",
                icon = Icons.Rounded.Email,
                action = { navController.navigate(Screen.Registration.route )}
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomBottom(
                text = "Вход через email",
                icon = Icons.Rounded.Email,
                action = { navController.navigate(Screen.SingIn.route )}
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomBottom(
                text = "регистрация через email",
                icon = Icons.Rounded.Email
            )
        }
    }
}


@Composable
private fun CustomBottom(
    text: String,
    icon: ImageVector,
    backgroundColor: Color = Color(0xFFF5FAFA),
    action: (() -> Unit)? = null
){
    TextButton(
        onClick = action?:{},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFF5FAFA)
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 10.dp,
            end = 20.dp,
            bottom = 10.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                imageVector = icon,
                contentDescription = "Email",
                colorFilter = ColorFilter.tint(Color(0xFF142B6F))
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = text.uppercase(),
                color = Color(0xFF142B6F)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewWelcomeScreen(){
    WelcomeScreen(navController = rememberNavController())
}