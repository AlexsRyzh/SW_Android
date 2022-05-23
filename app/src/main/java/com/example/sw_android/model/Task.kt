package com.example.sw_android.model

import androidx.annotation.Keep
import com.google.firebase.Timestamp


data class TaskDB(
    val TaskUid: String? = null,
    val UserUid: String? = null,
    val taskField:String? = null,
    val title: String? = null,
    val description:String? = null,
    val done: Boolean = false,
    val date: Date2? = null,
    val dateCreated: Timestamp? = null
)

data class Date2(
    val day: Int? = null,
    val month: Int? = null,
    val year: Int? = null,
)