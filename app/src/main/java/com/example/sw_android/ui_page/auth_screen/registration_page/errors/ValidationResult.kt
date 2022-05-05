package com.example.sw_android.ui_page.auth_screen.registration_page.errors

data class ValidationResult (
    val successful: Boolean,
    val errorMessage: String? = null
)