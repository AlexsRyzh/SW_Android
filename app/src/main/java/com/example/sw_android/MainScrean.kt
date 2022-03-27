package com.example.sw_android

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainViev() {
        Nav(name = "Задачи")
}


@Composable
fun Nav(name: String) {
    Column(modifier = Modifier.background(Color.Gray)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .background(Color.White)
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Card(
                elevation = 0.dp
            )
            {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = { /*TODO*/ },
                )
                {
                    Image(painter = painterResource(id = R.drawable.image),
                        contentDescription = "image",
                        modifier = Modifier.size(33.dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400),
                    fontSize = 20.sp

                )
                Text(
                    text = "Моё пространство",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp
                )
            }
            Card(
                elevation = 0.dp
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = { /*TODO*/ },
                ) {
                    Image(painter = painterResource(id = R.drawable.profi),
                        contentDescription = "profi",
                        modifier = Modifier.size(33.dp)
                    )
                }
            }
        }
        Card(shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp), elevation = 0.dp)
        {
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.03f)
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(start = 18.dp, end = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Text(text = "Список",
                    fontSize = 13.sp)

                Text(text = "Доска",
                    fontSize = 13.sp)

                Text(text = "Календарь",
                    fontSize = 13.sp)
            }
        }



        Row(
            modifier = Modifier
                .fillMaxHeight(0.93f)
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(20.dp)

        ){}

        Card(shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(10.dp)
            ){}
        }

    }
}



@Preview
@Composable
fun PrewivNav() {
    Nav("Задачи")
}