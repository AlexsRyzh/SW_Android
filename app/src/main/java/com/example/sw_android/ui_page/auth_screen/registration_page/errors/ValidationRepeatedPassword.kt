package com.example.sw_android.ui_page.auth_screen.registration_page.errors

class ValidationRepeatedPassword {
    fun check(password: String, repeatedPassword: String): ValidationResult{
        if (password!=repeatedPassword){
            return ValidationResult(
                successful = false,
                errorMessage = "Пароли не совпадают"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}