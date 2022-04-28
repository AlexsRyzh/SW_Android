package com.example.sw_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.registration_page.RegistrationScreen
import com.example.sw_android.singin_page.SingInScreen
import com.example.sw_android.welcome_page.WelcomeScreen

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.
        setContent {
            //navController = rememberNavController()
            //SetupNavGraph(navController = navController)
            RegistrationScreen()
        }
    }
}

