package com.example.sw_android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.ui_page.main_screen.task_page.TaskScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private lateinit var auth: FirebaseAuth;

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth
        var db = Firebase.firestore
        val settings = firestoreSettings {
            isPersistenceEnabled = true
        }
        db.firestoreSettings = settings
    }
    @RequiresApi(Build.VERSION_CODES.O)
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

