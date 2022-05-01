package com.example.sw_android.singin_page

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sw_android.registration_page.RegistrationFormEvent
import com.google.firebase.auth.FirebaseAuth

data class SingInUiState(
    val email: String = "",
    val emailError: String? = null,
    val password: String= "",
    val passwordError: String? = null

)


class SingInViewModel(
    private val auth: FirebaseAuth,
): ViewModel(){

    var _uiState by mutableStateOf(SingInUiState())
    var SingInSuccessful by mutableStateOf("")

    fun singInAccount(){
        auth.signInWithEmailAndPassword(_uiState.email,_uiState.password)
            .addOnCompleteListener{
                SingInSuccessful = if (it.isSuccessful){
                    "Successfull sing in"
                }else{
                    Log.d("ErrorSingIn","SingInUser::Error",it.exception)
                    "Fail"
                }
            }
    }


    fun onEvent(event: RegistrationFormEvent){
        when (event){
            is RegistrationFormEvent.EmailChanged -> {
                _uiState = _uiState.copy(email = event.email)
            }
            is RegistrationFormEvent.PasswordChanged -> {
                _uiState = _uiState.copy(password = event.password)
            }
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SingInViewModel as T
            }
        }
    }
}