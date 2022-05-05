package com.example.sw_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private lateinit var auth: FirebaseAuth;

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth
        if (auth.currentUser!=null){
            auth.signOut()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.
        setContent {
            navController = rememberNavController()
            RootNavGraph(
                navController = navController,
                mAuth = auth
            )
        }
    }
}

