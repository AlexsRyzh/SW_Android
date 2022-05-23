package com.example.sw_android.ui_page.main_screen.menu_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {
    var chek : Boolean by mutableStateOf(false)
}