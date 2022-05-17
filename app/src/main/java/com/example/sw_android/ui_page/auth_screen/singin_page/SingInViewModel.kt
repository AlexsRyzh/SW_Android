package com.example.sw_android.ui_page.auth_screen.singin_page

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sw_android.name_nodes_firebase.SAVE_ME
import com.example.sw_android.name_nodes_firebase.USERS_KEY
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

data class SingInUiState(
    val email: String = "",
    val password: String= "",
    val saveMe: Boolean = false
)


class SingInViewModel(
    private val auth: FirebaseAuth,
): ViewModel(){

    var _uiState by mutableStateOf(SingInUiState())
    var SingInSuccessful by mutableStateOf("")
    var activeProgressBar by mutableStateOf(false)

    private fun singInAccount(){
        auth.signInWithEmailAndPassword(_uiState.email,_uiState.password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    Firebase.database.reference.child(USERS_KEY).child(auth.uid!!).child(SAVE_ME).setValue(_uiState.saveMe)
                    SingInSuccessful = "Всё верно"
                }else{
                    Log.d("ErrorSingIn","SingInUser::Error",it.exception)
                    SingInSuccessful = " Неверный логин или пароль "
                }
            }
    }

    fun checkAndSingIn(){
        activeProgressBar = true;
        if (!_uiState.email.isBlank() && !_uiState.password.isBlank()){
            singInAccount()
        }else{
            SingInSuccessful = "Поля Email или Пароль не должны быть пустыми"
        }
        activeProgressBar = false;
    }

    fun onEvent(event: SingInFormEvent){
        when (event){
            is SingInFormEvent.EmailChanged -> {
                _uiState = _uiState.copy(email = event.email)
            }
            is SingInFormEvent.PasswordChanged -> {
                _uiState = _uiState.copy(password = event.password)
            }
            is SingInFormEvent.SaveMeChanged -> {
                _uiState = _uiState.copy(saveMe = event.saveMe)
            }
        }
    }

}