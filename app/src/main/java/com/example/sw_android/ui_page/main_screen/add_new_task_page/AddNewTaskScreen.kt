package com.example.sw_android.ui_page.main_screen.add_new_task_page

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import kotlinx.coroutines.launch
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddNewTaskScreen(
    navController: NavController,
    addNewTaskViewModel: AddNewTaskViewModel
) {
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    Column(
        modifier = Modifier
            .fillMaxSize()
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
                            text = "Этап",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    items(addNewTaskViewModel.state.taskFields) {
                        TextButton(onClick = {
                            addNewTaskViewModel.chageSelected(it.taskFieldName)
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
                                if (it.select){
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
            ) {
                Header()
                Head2(state, Modifier.weight(1f), addNewTaskViewModel = addNewTaskViewModel)
                BottomBar(mDatePickerDialog = mDatePickerDialog)
            }
        }
    }
}


@Composable
private fun BottomBar(
    mDatePickerDialog: DatePickerDialog
){
    Column{
        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(Color(0xFFB9B9B9)))
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
private fun Head2(
    state: ModalBottomSheetState,
    modifier: Modifier = Modifier,
    addNewTaskViewModel: AddNewTaskViewModel
) {
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .padding(horizontal = 18.dp)
    ) {
        TextButton(
            onClick = { scope.launch { state.show() }},
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
                    text = "Этап:",
                    color = Color.Black
                )

                addNewTaskViewModel.state.taskFields.find(predicate = {it.select == true})?.taskFieldName?.let {
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
            if (text1 == "") {
                Text(
                    text = "Название",
                    fontSize = 20.sp
                )
            }
            Column() {
                BasicTextField(
                    value = text1,
                    onValueChange = { text1 = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Black))
            }
            

        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            if (text2 == "") {
                Text(
                    text = "Описание",
                    fontSize = 16.sp
                )
            }
            Column() {
                BasicTextField(
                    value = text2,
                    onValueChange = { text2 = it },
                    textStyle = TextStyle(
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Black))
            }

        }

    }
}


@Composable
private fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextButton(
            modifier = Modifier.size(60.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(
                all = 0.dp
            )
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
        Text(
            text = "Новая задача",
            fontSize = 20.sp
        )
        TextButton(
            modifier = Modifier.size(60.dp),
            onClick = { /*TODO*/ },
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
    }
}

