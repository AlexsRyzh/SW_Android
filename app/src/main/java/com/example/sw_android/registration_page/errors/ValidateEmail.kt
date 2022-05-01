package com.example.sw_android.registration_page.errors

import android.util.Patterns

class ValidateEmail {
    fun check(email: String): ValidationResult{
        if (email.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "Email не может быть пустым"
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successful = false,
                errorMessage = "Это не валидный email"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}