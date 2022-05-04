package com.example.sw_android.ui_page.auth_screen.registration_page.errors

class ValidationTerms {
    fun check(acceptedTerms: Boolean): ValidationResult{
        if (!acceptedTerms){
            return ValidationResult(
                successful = false,
                errorMessage = "Пожалуйста, примите условия пользовательского соглашения"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}