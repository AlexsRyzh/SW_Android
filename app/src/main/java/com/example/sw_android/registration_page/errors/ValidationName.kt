package com.example.sw_android.registration_page.errors

class ValidationName {
    fun check(name: String): ValidationResult{
        if (name==""){
            return ValidationResult(
                successful = false,
                errorMessage = "Имя должно быть заполнено"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}