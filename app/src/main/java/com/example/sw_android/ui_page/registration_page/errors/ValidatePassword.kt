package com.example.sw_android.ui_page.registration_page.errors

class ValidatePassword {
    fun check(password: String): ValidationResult{
        if (password.length<8){
            return ValidationResult(
                successful = false,
                errorMessage = "Пароль должен содержать минимум 8 символов"
            )
        }
        val passwordContainsLetterAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if (!passwordContainsLetterAndDigits){
            return ValidationResult(
                successful = false,
                errorMessage = "Пароль должен содержать хотя бы одни символ и одну цифру"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}