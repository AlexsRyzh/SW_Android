package com.example.sw_android

import android.support.v4.os.IResultReceiver
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
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
        Column(modifier = Modifier
            .background(Color(red = 0xDF, green = 0xDC, blue = 0xDC, alpha = 0xFF))
            .fillMaxWidth()
            .fillMaxHeight(0.926f)
            .padding(start = 10.dp, end = 10.dp, top = 35.dp, bottom = 35.dp),
            ) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, bottom = 15.dp)) {
                Text(text = "Задачи",
                    fontSize = 23.sp)
            }

            Column(modifier = Modifier.fillMaxHeight(0.93f)) {
                TaskCard(task = "Сделать проект по самсунгу")
                TaskCard(task = "Подготовиться к кр по матанализу")
                TaskCard(task = "Сходить в магазин")
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {
                Image(painter = painterResource(id = R.drawable.adtask),
                    contentDescription = "adtask",
                    modifier = Modifier.size(38.dp))
            }
        }
}


@Composable
fun TaskCard(task: String){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 5.dp, end = 30.dp, bottom = 5.dp, top = 5.dp),
    elevation = 10.dp,
    shape = RoundedCornerShape(7.dp))
    //contentColor = Color.White)
        {
            Column() {


                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 3.dp, top = 10.dp)
                )
                {
                    Text(text = task)
                }


                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.padding(start = 20.dp, bottom = 3.dp)
                )
                {
                    //Image(
                    //    painter = painterResource(id = R.drawable.galochka),
                    //    contentDescription = "galochka",                              //ДОРАБОТАТЬ С КАРТИНКОЙ!!!
                     //   modifier = Modifier.size(10.dp)
                    //)
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
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(horizontal = 0.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painter = painterResource(id = R.drawable.chek),
                    contentDescription = "chek",
                    modifier = Modifier.size(18.dp))
                Text(text = "Задачи",
                    fontSize = 12.sp)
            }

        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(horizontal = 0.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = "chat",
                    modifier = Modifier.size(18.dp))
                Text(text = "Чат",
                    fontSize = 12.sp)
            }

        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(horizontal = 0.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painter = painterResource(id = R.drawable.stat  ),
                    contentDescription = "stat",
                    modifier = Modifier.size(18.dp))
                Text(text = "Статистика",
                    fontSize = 12.sp)
            }

        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            elevation = ButtonDefaults.elevation(0.dp),
            contentPadding = PaddingValues(horizontal = 0.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painter = painterResource(id = R.drawable.lupa),
                    contentDescription = "lupa",                              //ДОРАБОТАТЬ С КАРТИНКОЙ!!!
                    modifier = Modifier.size(18.dp))
                Text(text = "Поиск",
                    fontSize = 12.sp)
            }

        }

        Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            elevation = ButtonDefaults.elevation(0.dp),contentPadding = PaddingValues(horizontal = 0.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "menu",                              //ДОРАБОТАТЬ С КАРТИНКОЙ!!!
                    modifier = Modifier.size(18.dp))
                Text(text = "Меню",
                    fontSize = 12.sp)
            }

        }

    }
}


@Preview
@Composable
fun PrewivNavTop() {
    Column {
        NavTop("ООО.Энерго  Строй")
        Nav()
        NavBot()
    }
}