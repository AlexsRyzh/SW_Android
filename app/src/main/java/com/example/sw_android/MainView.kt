package com.example.sw_android

import android.media.Image
import android.support.v4.os.IResultReceiver
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.bottomappbar.BottomAppBar
import androidx.compose.material.BottomAppBar as BottomAppBar1


@Composable
fun MainView(){
    Column {
        NavTop("ООО.ЭнергоСтрой")
        Nav()
        NavBot()
    }
}



@Composable
fun NavTop(firma: String){     // сделать какую-либо общую перееменную для фирмы... взятое с рег.
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        )
    {
        Column(verticalArrangement = Arrangement.Center)
        {
            Text(
                text = "Задачи",
                fontSize = 25.sp

            )
            Text(
                text = firma,
                fontSize = 12.sp,
                color = Color(red = 0x9B, green = 0x9A, blue = 0x9A, alpha = 0xFF)

            )
        }
        Button(onClick = { /*TODO*/ },
               colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
               elevation = ButtonDefaults.elevation(0.dp),
                contentPadding = PaddingValues(0.dp)

        )
        {
            Image(painter = painterResource(id = R.drawable.treepoints),
                contentDescription = "treepoints",
                modifier = Modifier.size(35.dp))
        }
    }
}



@Composable
fun Nav(){
        Row(modifier = Modifier
            .background(Color(red = 0xDF, green = 0xDC, blue = 0xDC, alpha = 0xFF))
            .horizontalScroll(
                rememberScrollState()
            )
        )
        {
            Column(modifier = Modifier
                .background(Color(red = 0xDF, green = 0xDC, blue = 0xDC, alpha = 0xFF))
                .fillMaxWidth()
                .fillMaxHeight(0.926f)
                .padding(start = 10.dp, end = 10.dp, top = 35.dp),
            ) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, bottom = 15.dp)) {
                    Text(text = "Выполнить",
                        fontSize = 23.sp)
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .size(315.dp)
                        .verticalScroll(rememberScrollState())
                )
                {
                    TaskCard(task = "Сделать проект по самсунгу", R.drawable.emptly_chechbox)

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 18.dp)
                            .background(Color.Transparent),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 0xDF, green = 0xDC, blue = 0xDC, alpha = 0xFF)),
                            elevation = ButtonDefaults.elevation(0.dp),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.padding(top = 10.dp)
                        ) 
                        {
                            Image(painter = painterResource(id = R.drawable.adtask1),
                                contentDescription = "adtask",
                                modifier = Modifier.size(54.dp))
                        }
                    }
                }


            }
            Column(modifier = Modifier
                .background(Color(red = 0xDF, green = 0xDC, blue = 0xDC, alpha = 0xFF))
                .fillMaxWidth()
                .fillMaxHeight(0.926f)
                .padding(start = 10.dp, end = 10.dp, top = 35.dp),
            ) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, bottom = 15.dp)) {
                    Text(text = "Выполнено",
                        fontSize = 23.sp)
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .size(315.dp)
                        .verticalScroll(rememberScrollState())
                )
                {
                    TaskCard(task = "Сделать проект по самсунгу", R.drawable.chekbox)

                }
            }
        }
}


@Composable
fun NavBot(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        ButtonNuvBot(R.drawable.chek,"chek", "Задачи")
        ButtonNuvBot(R.drawable.chat,"chat", "Чат")
        ButtonNuvBot(R.drawable.stat,"stat", "Статистика")
        ButtonNuvBot(R.drawable.lupa,"lupa", "Поиск")
        ButtonNuvBot(R.drawable.menu,"menu", "Меню")
        }
}


@Composable
fun TaskCard(task: String, IdImage: Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(7.dp))
    //contentColor = Color.White)
    {
        Row() {


            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp)
                    .fillMaxWidth(0.85f)
            )
            {
                Text(text = task)
            }


            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            )
            {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    elevation = ButtonDefaults.elevation(0.dp),
                    contentPadding = PaddingValues(3.dp)) {
                    Image(
                        painter = painterResource(id = IdImage),
                        contentDescription = "Task",                              //ДОРАБОТАТЬ С КАРТИНКОЙ!!!
                        modifier = Modifier.size(36.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun ButtonNuvBot(idImage: Int, TextImage: String, Text: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(0.dp),
        contentPadding = PaddingValues(horizontal = 0.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = TextImage,
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = Text,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun PrewivNavTop() {
    Column(modifier = Modifier.fillMaxHeight()) {
        NavTop("ООО.ЭнергоСтрой")
        Nav()
        NavBot()
    }
}