package com.example.sw_android.singin_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow

data class SingInUiState(
    var email: String = "",
    var password: String= ""
)


class SingInViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(SingInUiState())



    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SingInViewModel as T
            }
        }
    }
}