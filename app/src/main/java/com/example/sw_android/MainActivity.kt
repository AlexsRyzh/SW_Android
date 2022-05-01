package com.example.sw_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.registration_page.RegistrationScreen
import com.example.sw_android.singin_page.SingInScreen
import com.example.sw_android.welcome_page.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private lateinit var auth: FirebaseAuth;


    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        this.
        setContent {
            navController = rememberNavController()
            SetupNavGraph(
                navController = navController,
                mAuth = auth
            )
        }
    }
}

