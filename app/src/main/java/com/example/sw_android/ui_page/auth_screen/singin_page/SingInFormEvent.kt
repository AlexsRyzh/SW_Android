package com.example.sw_android.ui_page.auth_screen.singin_page



sealed class SingInFormEvent {
    data class EmailChanged(val email: String): SingInFormEvent()
    data class PasswordChanged(val password: String): SingInFormEvent()
    data class SaveMeChanged(val saveMe: Boolean): SingInFormEvent()
}