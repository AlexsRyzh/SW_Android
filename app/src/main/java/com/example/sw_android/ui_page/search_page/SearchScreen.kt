package com.example.sw_android.ui_page.search_page

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sw_android.R

data class ListProject(
    val name: String = "Проекты",
    val viewAll: String = "Все проекты",
    val listProject: List<Project> = listOf(
        Project(
            icon = R.drawable.stadia_controller,
            title = "Game Desing",
            description = "Create menu in dashboard & Make user flow .."
        ),
        Project(
            icon = R.drawable.stadia_controller,
            title = "Game Desing",
            description = "Create menu in dashboard & Make user flow .."
        ),
        Project(
            icon = R.drawable.stadia_controller,
            title = "Game Desing",
            description = "Create menu in dashboard & Make user flow .."
        ),
        Project(
            icon = R.drawable.stadia_controller,
            title = "Game Desing",
            description = "Create menu in dashboard & Make user flow .."
        )

    )
)
data class ListTask(
    val name: String = "Задания",
    val viewAll: String = "Все задания",
    var listTask: List<Task> = mutableListOf(
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        ),
        Task(
            done = true,
            description = "Сделать меню в dashboard на ..."
        )

    )
)

data class Project(
    @DrawableRes val icon: Int,
    val title: String,
    val description: String,
)

data class Task(
    var done: Boolean = false,
    val description: String,
)

@Composable
fun SearchScreen(){
    var searchText by remember {
        mutableStateOf("")
    }
    val listProject1 = remember {
        mutableListOf<Project>(
            Project(
                icon = R.drawable.stadia_controller,
                title = "Game Desing",
                description = "Create menu in dashboard & Make user flow .."
            ),
            Project(
                icon = R.drawable.stadia_controller,
                title = "Game Desing",
                description = "Create menu in dashboard & Make user flow .."
            ),
            Project(
                icon = R.drawable.stadia_controller,
                title = "Game Desing",
                description = "Create menu in dashboard & Make user flow .."
            ),
            Project(
                icon = R.drawable.stadia_controller,
                title = "Game Desing",
                description = "Create menu in dashboard & Make user flow .."
            )
        )
    }
    var listTask1 = ListTask()
    Column(
        modifier = Modifier
            .background(Color(0xffF6F6F6))
    ) {
        LazyColumn{
            item {
                Header(
                    str1 = "Привет Марин",
                    str2 = "Давайте найдём ваш лучший проект!",
                    searchText = searchText,
                    onValueChange = {searchText = it}
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                SectionHead(sectionName = "Проекты", viewAll = "Все проекты")
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                LazyRow{
                    item { Spacer(modifier = Modifier.width(20.dp)) }
                    items(listProject1){
                        ProjectCard(project = it)
                    }
                    item { Spacer(modifier = Modifier.width(20.dp)) }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                SectionHead(sectionName = "Задания", viewAll = "Все задания")
                Spacer(modifier = Modifier.height(15.dp))
            }
            items(listTask1.listTask){ item ->
                TaskCard(task = item)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }


    }
}

@Composable
private fun TaskCard(
    task: Task
){
    var done by remember {
        mutableStateOf(true)
    }
    Row() {
        Spacer(modifier = Modifier.width(20.dp))
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(25),
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .background(Color(0xffFFFFFF))
            ) {
                Checkbox(
                    checked = done,
                    onCheckedChange = {done = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xff2E2E2E),
                        uncheckedColor = Color(0xff2E2E2E)
                    ),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = task.description)
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
    }

}

@Composable
private fun ProjectCard(
    project: Project
){
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(20),
        backgroundColor = Color(0xff2E2E2E),
        modifier = Modifier
            .width(150.dp)
            .height(192.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 20.dp,
                    end = 20.dp,
                    bottom = 10.dp
                )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = Color(0xffF6F6F6),
                        shape = RoundedCornerShape(50)
                    )
            ){
                Icon(
                    painter = painterResource(id = project.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = project.title,
                color =  Color(0xffF6F6F6)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = project.description,
                color =  Color(0xffBABABA)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier.fillMaxWidth()
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            color = Color(0xffF6F6F6),
                            shape = RoundedCornerShape(50)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward),
                        contentDescription = null,
                        tint = Color(0xff2E2E2E),
                        modifier = Modifier
                            .width(12.dp)
                            .height(20.dp)
                    )
                }
            }

        }
    }
    Spacer(modifier = Modifier.width(20.dp))
}

@Composable
private fun SectionHead(
    sectionName: String,
    viewAll: String,
    evenViewAll: (() -> Unit)? = null
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ){
        Text(
            text = sectionName,
            fontSize = 24.sp,
            color = Color(0xff2E2E2E),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = viewAll,
            fontSize = 12.sp,
            color = Color(0xffA8A8A8),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable(onClick = evenViewAll?:{})
        )
    }
}

@Composable
fun Header(
    str1: String,
    str2: String,
    searchText: String,
    onValueChange: (String) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Column(
            modifier = Modifier
                .height(150.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xff2E2E2E),
                        RoundedCornerShape(30)
                    )
                    .fillMaxWidth()
                    .weight(1f)
            )
            Box(
                modifier = Modifier
                    .height(20.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 20.dp,
                    end = 20.dp,
                )
        ) {
            Text(
                text = str1,
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = str2,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .width(155.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            CustomSearchTextField(
                searchText = searchText,
                onValueChange = onValueChange,
                labelText = "Поиск проекта, задачи или фирмы"
            )
        }
    }
}

@Composable
private fun CustomSearchTextField(
    searchText: String,
    onValueChange: (String) -> Unit,
    labelText: String
){
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(30),
        backgroundColor = Color(0xffF6F7FB)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    top = 10.dp,
                    end = 15.dp,
                    bottom = 10.dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color(0xffD3D3D3),
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .weight(1f)
            ){
                BasicTextField(
                    value = searchText ,
                    onValueChange = onValueChange,
                    textStyle = TextStyle(
                        color = Color(0xff2E2E2E),
                        fontSize = 14.sp
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                if (searchText == "") {
                    Text(text = labelText, fontSize = 12.sp, color = Color(0xffD3D3D3))
                }

            }

            Spacer(modifier = Modifier.width(10.dp))
            SettingIcon()
        }
    }

}

@Composable
fun SettingIcon(){
    Column(
        modifier = Modifier
            .background(
                color = Color(0xff2E2E2E),
                shape = RoundedCornerShape(25)
            )
            .padding(
                horizontal = 7.dp,
                vertical = 8.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.rectangle),
                contentDescription = null,
                tint = Color(0xffFFFFFF),
                modifier = Modifier
                    .width(8.dp)
                    .height(4.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Icon(
                painter = painterResource(id = R.drawable.cicle),
                contentDescription = null,
                tint = Color(0xffFFFFFF),
                modifier = Modifier
                    .size(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cicle),
                contentDescription = null,
                tint = Color(0xffFFFFFF),
                modifier = Modifier
                    .size(4.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Icon(
                painter = painterResource(id = R.drawable.rectangle),
                contentDescription = null,
                tint = Color(0xffFFFFFF),
                modifier = Modifier
                    .width(8.dp)
                    .height(4.dp)
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun SearchScreenPreview(){
    SearchScreen()
}