package com.example.sw_android.ui_page.main_screen.task_page

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.legacy.widget.Space
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.R
import com.example.sw_android.ui.theme.Black2E2E

data class Task(
    val title: String = "Title",
    val description: String = "Description",
    val day: String = "12",
    val month: String = "апрель"
)

@Composable
fun TaskScreen(
    navController: NavController
){
    val tasks = mutableListOf<Task>(
        Task(),
        Task(),
        Task(),
        Task(),
        Task(),
        Task(),
        Task()
    )
    Column(
        modifier = Modifier
            .background(color = Color(0xffF6F6F6))
            .fillMaxSize()
    ) {
        Header(title = "Задачи", spaceName = "Мое пространство")
        LazyRow(
            contentPadding = PaddingValues(
                top = 30.dp,
                start = 20.dp,
                end = 20.dp
            ),
            modifier = Modifier.weight(1f)
        ){
            items(3){
                LazyColumn{
                    item{
                        HeaderList(title = "Законечено", numberOf = tasks.size)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    items(tasks){
                        TaskCard(text = it.title, day = it.day, month = it.month)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            item{
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Black2E2E,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.add_box),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Добавить раздел")
                    }
                }
            }
        }
    }
}

@Composable
private fun Header(
    title: String,
    spaceName: String
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Black2E2E,
                shape = RoundedCornerShape(25)
            )
            .padding(
                horizontal = 25.dp,
                vertical = 15.dp
            )
    ) {
        Column() {
            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = spaceName,
                color = Color.White
            )
        }
        Box() {
            settingIcon()
        }
    }
}

@Composable
private fun HeaderList(
    title: String,
    numberOf: Int
){
    Row() {
        Text(
            text = title,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "($numberOf)",
            fontSize = 14.sp
        )
    }
}


@Composable
private fun settingIcon(){
    Column() {
        Icon(
            painter = painterResource(id = R.drawable.cicle),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(4.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Icon(
            painter = painterResource(id = R.drawable.cicle),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(4.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Icon(
            painter = painterResource(id = R.drawable.cicle),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(4.dp)
        )
    }
}

@Composable
private fun TaskCard(
    text: String,
    day: String,
    month: String
){
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(20),
        backgroundColor = Color.White,
        modifier = Modifier
            .width(300.dp)
            .height(72.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        ) {
            Text(
                text = text,
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                DateCard(day = day, month = month)
            }
        }
    }
}

@Composable
private fun DateCard(
    day: String,
    month: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color(0xff2E2E2E),
                shape = RoundedCornerShape(50)
            )
            .width(52.dp)
            .height(20.dp)
            .padding(
                horizontal = 5.dp,
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.calendar),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(14.dp)
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = day,
            color = Color.White,
            fontSize = 8.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = month,
            color = Color.White,
            overflow = TextOverflow.Clip,
            fontSize = 8.sp,
            maxLines = 1
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TaskScreenPreview(){
    TaskScreen(navController = rememberNavController())
}