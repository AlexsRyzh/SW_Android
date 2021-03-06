package com.example.sw_android.ui_page.main_screen.edit_task_page

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sw_android.R
import com.example.sw_android.Screen
import kotlinx.coroutines.launch
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditeTaskScreen(
    navController: NavController,
    editeTaskViewModel: EditeTaskViewModel
) {
    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            editeTaskViewModel.changeDate(
                day = mDayOfMonth,
                month = mMonth,
                year = mYear
            )
        }, mYear, mMonth, mDay
    )
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ModalBottomSheetLayout(
            sheetState = state,
            sheetShape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp
            ),
            sheetContent = {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        end = 20.dp,
                        top = 10.dp
                    )
                ) {
                    item {
                        Text(
                            text = "????????",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    items(editeTaskViewModel.state.taskFields) {
                        TextButton(onClick = {
                            editeTaskViewModel.chageSelected(it.taskFieldName)
                        }) {
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = it.taskFieldName,
                                    fontSize = 20.sp,
                                    color = if (it.select) Color(0xffE52900) else Color.Black
                                )
                                if (it.select) {
                                    Icon(
                                        imageVector = Icons.Filled.Done,
                                        contentDescription = null,
                                        tint = Color(0xffE52900)
                                    )
                                }

                            }
                            Spacer(modifier = Modifier.height(5.dp))
                        }

                    }
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Header(navController = navController, editeTaskViewModel = editeTaskViewModel)
                Content(state, Modifier.weight(1f), editeTaskViewModel = editeTaskViewModel)
                BottomBar(mDatePickerDialog = mDatePickerDialog)
            }
        }
    }
}


@Composable
private fun BottomBar(
    mDatePickerDialog: DatePickerDialog
) {
    Column {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xFFB9B9B9))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            IconButton(onClick = { mDatePickerDialog.show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = Color(0xFFACACAC)
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Content(
    state: ModalBottomSheetState,
    modifier: Modifier = Modifier,
    editeTaskViewModel: EditeTaskViewModel
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .padding(horizontal = 18.dp)
    ) {
        TextButton(
            onClick = { scope.launch { state.show() } },
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .width(200.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(Color(0xFFECECEC), shape = RoundedCornerShape(20))
                    .padding(
                        vertical = 3.dp,
                        horizontal = 3.dp
                    )

            ) {
                Text(
                    text = "????????:",
                    color = Color.Black
                )

                editeTaskViewModel.state.taskFields.find(predicate = { it.select == true })?.taskFieldName?.let {
                    Text(
                        text = it,
                        color = Color(0xffE52900)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            if (editeTaskViewModel.state.task.title == "") {
                Text(
                    text = "????????????????",
                    fontSize = 20.sp
                )
            }
            Column() {
                BasicTextField(
                    value = editeTaskViewModel.state.task.title!!,
                    onValueChange = { editeTaskViewModel.changeTasktitle(it) },
                    textStyle = TextStyle(
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }


        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            if (editeTaskViewModel.state.task.description == "") {
                Text(
                    text = "????????????????",
                    fontSize = 16.sp
                )
            }
            Column() {
                BasicTextField(
                    value = editeTaskViewModel.state.task.description!!,
                    onValueChange = { editeTaskViewModel.changeTaskDescrip(it) },
                    textStyle = TextStyle(
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            Row() {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_done),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = editeTaskViewModel.currentDate,
                    fontSize = 16.sp
                )
            }
        }

    }
}


@Composable
private fun Header(
    navController: NavController,
    editeTaskViewModel: EditeTaskViewModel
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextButton(
            modifier = Modifier.size(60.dp),
            onClick = {
                editeTaskViewModel.saveTask()
                navController.navigateUp()},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(
                all = 0.dp
            )
        ) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
        Text(
            text = "?????????? ????????????",
            fontSize = 20.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleCheckbox(
                selected = editeTaskViewModel.state.task.done,
                onChecked = { editeTaskViewModel.changeDone(!editeTaskViewModel.state.task.done)}
            )
            TextButton(
                modifier = Modifier.size(60.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(
                    all = 0.dp
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete_forever),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        }

    }
}
@Composable
fun CircleCheckbox(selected: Boolean, enabled: Boolean = true, onChecked: () -> Unit) {

    val imageVector = if (selected) painterResource(id = R.drawable.check_circle) else painterResource(id = R.drawable.circle)
    val tint = if (selected) Color(0xffE52900).copy(alpha = 0.8f) else Color.Gray.copy(alpha = 0.8f)
    val background = if (selected) Color.White else Color.Transparent

    TextButton(onClick = { onChecked() },
        modifier = Modifier
            .height(60.dp)
            .width(40.dp),
        enabled = enabled,
        contentPadding = PaddingValues(all = 0.dp)
    ) {

        Icon(painter = imageVector, tint = tint,
            modifier = Modifier
                .background(background, shape = CircleShape)
                .size(25.dp),
            contentDescription = "checkbox")
    }
}


