package com.example.sw_android.ui_page.auth_screen.registration_page

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sw_android.model.User
import com.example.sw_android.ui_page.auth_screen.registration_page.errors.*
import com.example.sw_android.ui_page.auth_screen.singin_page.SingInViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class RegistrationUiState(
    val name: String = "",
    val nameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null
)



class RegistrationViewModel(
    private val auth: FirebaseAuth,
    private val validateName: ValidationName = ValidationName(),
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidationRepeatedPassword = ValidationRepeatedPassword(),
    private val validateTerms: ValidationTerms = ValidationTerms()

) : ViewModel() {

    var state by mutableStateOf(RegistrationUiState())
    var regSuccessful by mutableStateOf("")
    val db = Firebase.firestore.collection("User")
    var activeProgressBar by mutableStateOf(false)


    fun checkState(){

        activeProgressBar = true

        val nameResult = validateName.check(state.name)
        val emailResult = validateEmail.check(state.email)
        val passwordResult = validatePassword.check(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.check(state.password, state.repeatedPassword)
        val termsResult = validateTerms.check(state.acceptedTerms)

        val hasError = listOf(
            nameResult,
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if (hasError){
            state = state.copy(
                nameError = nameResult.errorMessage,
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            regSuccessful = "False"
            activeProgressBar = false
            return
        }
        createAccount()
        activeProgressBar = false
    }

    private fun createAccount(){
        auth.createUserWithEmailAndPassword(state.email,state.password)
            .addOnCompleteListener{task ->
                if (task.isSuccessful){
                    var user = User(state.name,state.email,state.password,state.acceptedTerms,true)
                    db.document(auth.uid!!).set(user)
                    Log.d("User successful", "createUserWithEmail:success")
                    regSuccessful = "True"
                }else{
                    Log.d("CreateUser","Error",task.exception)
                    regSuccessful = "False"
                }
            }
    }

    fun onEvent(event: RegistrationFormEvent){
        when (event){
            is RegistrationFormEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.RepeatedPasswordChanged ->{
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            is RegistrationFormEvent.AcceptedTermsChanged -> {
                state = state.copy(acceptedTerms = event.acceptedTerms)
            }
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return RegistrationViewModel as T
            }
        }
    }
}


