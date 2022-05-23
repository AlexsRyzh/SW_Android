package com.example.sw_android.model

import androidx.annotation.Keep


data class TaskDB(
    val TaskUid: String? = null,
    val UserUid: String? = null,
    val taskField:String? = null,
    val title: String? = null,
    val description:String? = null,
    val day: Int? = null,
    val month: Int? = null,
    val year: Int? = null
)