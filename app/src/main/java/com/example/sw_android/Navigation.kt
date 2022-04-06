package com.example.sw_android

import androidx.fragment.app.Fragment
import java.security.InvalidParameterException

enum class Screen{
    Welcome,
    SingUp,
    SingIn
}

fun Fragment.navigate(to: Screen, from: Screen){
    if (to==from){
        throw InvalidParameterException("Can't navigate to $to")
    }
    when(to){

    }
}