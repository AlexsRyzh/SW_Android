package com.example.sw_android.model

data class User(
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
    val acceptedTerms: Boolean? = null,
    val saveMe: Boolean? = null,
    var picture: Boolean? = null
)