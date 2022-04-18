package com.example.sw_android.ui.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomBottomBar(
    firstText: String? = null,
    secondText: String? = null,
    onClick: (() -> Unit)? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        if (firstText!=null){
            Text(
                text = firstText,
                color = Color(0xff1A22ED),
                fontSize = 14.sp
            )
        }

        if (secondText!=null){
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = secondText,
                color = Color(0xffDD0909),
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable(onClick = onClick?:{})
            )
        }

    }
}