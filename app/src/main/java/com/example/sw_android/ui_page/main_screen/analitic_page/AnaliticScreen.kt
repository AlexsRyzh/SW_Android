package com.example.sw_android.ui_page.main_screen.analitic_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun AnaliticScreen(
    navController: NavController
){    //Отображение экрана
    Column(modifier = Modifier  // эл-ты по вертикали
        .fillMaxSize()
        .background(Color(0xFFDFDCDC))) {

        Card(modifier = Modifier // Верхняя шапка с надписью "Аналитика"
            .fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            Color(0xFF2E2E2E))
        {
            Box(modifier =Modifier.padding(start = 20.dp, top = 15.dp, bottom =  15.dp))
            {
                Text(text = "Аналитика",fontSize = 25.sp, color = Color.White)
            }
        }
        // Вызов 2 методов которые реализуют 2 карточки с разными параметрами
        Card1_2(text = "Выполнено всего", tasks = 2,20,20,40,10)
        Card1_2(text = "Просрочено всего", tasks = 1,20,20,10,10)

        // Вывод графика аналитики
        // Массив хранящий данные выполненных задач по каждому дню (каждый день массив должен обновляться)
        val mas: Array<Int> = arrayOf(11, 14, 13, 16, 15)
        Graph(mas)
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
fun Graph(mas: Array<Int>){
    //Преобразование массива для вывода кол-ва задач слева
    val mas_ishod = mutableListOf(0)
    for (i in mas)
        mas_ishod.add(i)
    mas_ishod.remove(0)
    mas.sort()
    val mas_2 = mutableListOf(0)
    var maksimum = (mas[4] + 1)
    var count = 0;
    var c = -1;
    for(i in 0..4){
        if(mas[i] > c){
            mas_2.add(mas[i])
            c = mas[i]
            count++
        }
    }
    mas_2.remove(0)
    while (count != 5){
        mas_2.add(maksimum)
        maksimum++
        count++
    }

    //Конец преобразований
    // mas_ishod - содержит в себе изначальные/входные значения и их порядок
    // mas_2 - упорядоченный по возрастанию массив в котором содержится 5 неповторяющихся эл-ов

    Card(modifier = Modifier  //Отисовка графика
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
        shape = RoundedCornerShape(18.dp),
        Color(red = 0x2E, green = 0x2E, blue = 0x2E))
    {
        Box(modifier = Modifier.padding(15.dp)) {
            Canvas(
                modifier = Modifier                            // изменение по y - 61.25, по x -
                    .padding(start = 45.dp, bottom = 5.dp, top = 10.dp)
                    .background(Color.Yellow)
            ) {
                var key = 0 //Ключевые значения для смещения по игрику
                var key_last = 0
                for (i in 0..4) {
                    for (j in 0..4) {
                        if (mas_ishod[i] == mas_2[j]) {
                            key = j
                        }
                    }
                    if (i >= 1) {
                        for (j in 0..4) {
                            if (mas_ishod[i - 1] == mas_2[j]) {
                                key_last = j
                                Log.i(TAG, "Check = $key_last")
                            }
                        }
                    }
                    key = 4 - key
                    key_last = 4 - key_last

                    //Log.i(TAG, "Key = $key")
                    //Log.i(TAG, "Key_last = $key_last")
                    drawCircle(
                        color = Color.White,
                        center = Offset(x = i * 150f, y = key * 68f),
                        radius = 8f
                    )
                    if (i >= 1) {
                        drawLine(
                            start = Offset(x = (i - 1) * 150f, y = key_last * 68f),
                            end = Offset(x = i * 150f, y = key * 68f),
                            color = Color.White,
                            strokeWidth = 5F
                        )
                    }
                    drawLine(
                        start = Offset(x = -40f, y = i * 68f),
                        end = Offset(x = 4 * 150f + 40f, y = i * 68f),
                        color = Color.White,
                        strokeWidth = 0.5F
                    )
                }
            }
            //Конец отрисовки графика
            Column()
            {
                for (n in 4 downTo 0){
                    TextInCard3(text = mas_2[n].toString(), size = 16) //вывод кол-во задач
                }
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                )
                {

                    for (i in 5 downTo 1) {  //Вывод дат
                        val dateFormat: DateFormat = SimpleDateFormat("dd.MM")
                        val cal = Calendar.getInstance()
                        cal.add(Calendar.DATE, -i);
                        val dtext = dateFormat.format(cal.time)
                        Log.i(TAG, "Data = $dtext")
                        Log.i(TAG, "I = $i")
                        TextInCard3_horiontal(text = dtext, size = 16)
                    }
                }
            }
        }
    }
}


@Composable
fun Card1_2(text: String, tasks: Int, dp_start: Int, dp_end: Int, dp_top: Int, dp_bottom: Int){
    Card(modifier = Modifier // Создание карточки и задание основных параметров отображения
        .fillMaxWidth()
        .padding(start = dp_start.dp, end = dp_end.dp, top = dp_top.dp, bottom = dp_bottom.dp),
        shape = RoundedCornerShape(18.dp),
        Color(red = 0x2E, green = 0x2E, blue = 0x2E))
    {
        Box(modifier =Modifier.padding(15.dp))
        {
            Column() {
                Text(text = text,fontSize = 18.sp, color = Color.White,  // Вывод текста на карточке
                    modifier = Modifier.padding(bottom = 10.dp, start = 10.dp))
                Row() {
                    val print_task: String = tasks.toString()  // Перевод переменной tasks к типу int
                    Text(text = print_task,fontSize = 23.sp, color = Color.White,
                        modifier = Modifier.padding(start = 25.dp))

                    // Условие выбора окончания - задач(-и)(-а)
                    if(2 <= (tasks % 10) && (tasks % 10) <= 4 &&
                        (tasks != 12) && (tasks != 13) && (tasks != 14))
                        TextInCard1_2("задачи")
                    else if((0 == (tasks % 10) || 5 <= (tasks % 10) && (tasks % 10) <= 9) ||
                        ((tasks == 11) || (tasks == 12) || (tasks == 13) || (tasks == 14)))
                        TextInCard1_2("задач")
                    else if(tasks % 10 == 1)
                        TextInCard1_2("задача")
                }
            }
        }
    }
}

@Composable
fun TextInCard1_2(text: String) {
    Text(
        text = text, fontSize = 13.sp, color = Color.White,
        modifier = Modifier.padding(start = 5.dp)
    )
}

@Composable
fun TextInCard3(text: String, size: Int) {
    Text(
        text = text, fontSize = size.sp, color = Color.White
    )
}

@Composable
fun TextInCard3_horiontal(text: String, size: Int) {
    Text(
        text = text, fontSize = size.sp, color = Color.White,
        modifier = Modifier.padding(start = 5.dp,end = 5.dp)
    )
}

@Preview
@Composable
fun AnaliticShow() {
    AnaliticScreen(rememberNavController())
}


@Preview
@Composable
fun PrewivNavTop() {
    Column(modifier = Modifier.fillMaxHeight()) {

    }
}