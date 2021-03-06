package com.example.sw_android.ui_page.auth_screen.registration_page

sealed class RegistrationFormEvent {
    data class NameChanged(val name: String): RegistrationFormEvent()
    data class EmailChanged(val email: String): RegistrationFormEvent()
    data class PasswordChanged(val password: String): RegistrationFormEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String): RegistrationFormEvent()
    data class AcceptedTermsChanged(val acceptedTerms: Boolean): RegistrationFormEvent()

    object CreateAccount: RegistrationFormEvent()
}