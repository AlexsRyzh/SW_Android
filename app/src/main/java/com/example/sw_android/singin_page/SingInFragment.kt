package com.example.sw_android.singin_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView

class SingInFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {

        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)

        setContent {
            Text(text = "Вход")
        }
    }
}