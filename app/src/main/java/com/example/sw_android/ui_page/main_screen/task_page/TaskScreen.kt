package com.example.sw_android.ui_page.main_screen.task_page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.legacy.widget.Space
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.R
import com.example.sw_android.Screen
import com.example.sw_android.ui.theme.Black2E2E
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior


@OptIn(ExperimentalSnapperApi::class, ExperimentalPagerApi::class)
@Composable
fun TaskScreen(
    navController: NavController,
    navController2: NavController,
    taskFieldViewModel: TaskViewModel
) {
    var activeAddField by remember {
        mutableStateOf(false)
    }
    Box {
        Column(
            modifier = Modifier
                .background(color = Color(0xffF6F6F6))
                .fillMaxSize()
        ) {
            Header(title = "Задачи", spaceName = "Мое пространство")
            HorizontalPager(
                count = taskFieldViewModel.state.taskFields.size + 1,
                contentPadding = PaddingValues(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                )
            ) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    when (page) {
                        taskFieldViewModel.state.taskFields.size -> {
                            TextButton(
                                onClick = { activeAddField = true },
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
                                    Text(
                                        text = "Добавить раздел",
                                    )
                                }
                            }
                        }
                        else -> {
                            HeaderList(
                                title = taskFieldViewModel.state.taskFields[page],
                                numberOf = taskFieldViewModel.state.tasks.count { it.taskField == taskFieldViewModel.state.taskFields[page] },
                                taskFieldViewModel = taskFieldViewModel
                            )
                            LazyColumn() {
                                items(
                                    taskFieldViewModel.state.tasks.filter { it.taskField == taskFieldViewModel.state.taskFields[page]}
                                ) {
                                    TaskCard(
                                        text = it.title!!,
                                        day = it.day,
                                        month = it.month,
                                        taskViewModel = taskFieldViewModel,
                                        taskUid = it.TaskUid!!,
                                        navController = navController2
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                }
                            }

                        }
                    }

                }


            }
        }
        if (activeAddField) {
            var text by remember { mutableStateOf("") }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.4f)
                        .background(Color.Black)
                )
                Card(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20),
                    modifier = Modifier.width(300.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
                    ) {
                        Text(
                            text = "Добавить этап",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Column {
                            BasicTextField(
                                value = text,
                                onValueChange = { text = it },
                                textStyle = TextStyle(
                                    fontSize = 16.sp
                                ),
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.Black)
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Отмена",
                                fontSize = 16.sp,
                                modifier = Modifier.clickable { activeAddField = false }
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "Добавить",
                                fontSize = 16.sp,
                                color = Color.Red,
                                modifier = Modifier.clickable {
                                    taskFieldViewModel.setWorkFieldName(
                                        text
                                    )
                                    activeAddField = false
                                }
                            )
                        }
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
) {
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
                vertical = 10.dp
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
    numberOf: Int,
    taskFieldViewModel: TaskViewModel
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
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
        Row() {
            IconButton(onClick = {
                taskFieldViewModel.deletTaskField(title)
            }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription =null)
            }
            Spacer(modifier = Modifier.width(20.dp))
        }
        
    }

}


@Composable
private fun settingIcon() {
    Column() {
        Icon(
            painter = painterResource(id = R.drawable.cicle),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(5.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Icon(
            painter = painterResource(id = R.drawable.cicle),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(5.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Icon(
            painter = painterResource(id = R.drawable.cicle),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(5.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
private fun TaskCard(
    text: String,
    day: Int?,
    month: Int?,
    taskUid: String,
    taskViewModel: TaskViewModel,
    navController: NavController
) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(20),
        backgroundColor = Color.White,
        modifier = Modifier
            .width(300.dp)
            .height(72.dp)
            .clickable { navController.navigate("${Screen.EditTaskScreen.route}/${taskUid}") }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
            Spacer(modifier = Modifier.height(5.dp))
            if (day !=null && month!=null)
                Row() {
                    DateCard(day = day.toString(), month = taskViewModel.getCurrentDate(month = month))
                }
        }
    }
}

@Composable
private fun DateCard(
    day: String,
    month: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color(0xff2E2E2E),
                shape = RoundedCornerShape(40)
            )
            .width(60.dp)
            .height(20.dp)
            .padding(
                horizontal = 5.dp,
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.calendar_done),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(14.dp)
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = day,
            color = Color.White,
            fontSize = 12.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = month,
            color = Color.White,
            overflow = TextOverflow.Clip,
            fontSize = 12.sp,
            maxLines = 1
        )
    }
}

