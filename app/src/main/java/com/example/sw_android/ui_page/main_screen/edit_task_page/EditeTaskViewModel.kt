package com.example.sw_android.ui_page.main_screen.edit_task_page

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sw_android.model.TaskDB
import com.example.sw_android.model.TaskFields
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

data class EdiTaskUiState(
    var taskFields: MutableList<EditTaskField> = mutableListOf(),
    var selectedTaskField: String? = null,
    var task: TaskDB = TaskDB(
        title = "",
        description = "",
        day = null,
        month = null,
        year = null
    )
)

data class EditTaskField(
    var select: Boolean = false,
    var taskFieldName: String = ""
)

class EditeTaskViewModel(
    private val auth: FirebaseAuth,
    private val taskUid: String
): ViewModel(){

    var state by mutableStateOf(EdiTaskUiState())
    var currentDate by mutableStateOf("--/--/----")
    private var db = Firebase.firestore

    init {
        refreshTaskField()
    }

    private fun refreshTaskField() {
        auth.uid?.let {
            db.collection("WorkField").document(it).get().addOnSuccessListener { snapshot ->
                Log.d(ContentValues.TAG, "Current data1: ${snapshot.data}")
                var taskFiel2 = mutableListOf<EditTaskField>()
                snapshot.toObject<TaskFields>()?.taskFields?.forEach { name ->
                    taskFiel2.add(EditTaskField(false, name))
                }
                if (taskFiel2.size > 0) {
                    taskFiel2[0].select = true
                }
                state = state.copy(
                    taskFields = taskFiel2.filter { true } as MutableList<EditTaskField>,
                )
                var selectedTaskField =
                    state.taskFields.find({ it.select == true })?.let { it.taskFieldName }
                state = state.copy(
                    selectedTaskField = selectedTaskField
                )
            }
        }
        db.collection("Task").document(taskUid).get().addOnSuccessListener {
            if (it != null) {
                val taskDb2 = it.toObject<TaskDB>()
                state = state.copy(
                    task = taskDb2!!
                )
            }
            Log.d("fdfd", "nonoCurrent ${state.task}")
            currentDate()

        }
    }

    fun saveTask(){
        auth.uid?.let {
            val taskDB = TaskDB(
                UserUid = auth.uid,
                taskField = state.selectedTaskField,
                title = state.task.title,
                description = state.task.description,
                day = state.task.day,
                month = state.task.month,
                year = state.task.year
            )
            db.collection("Task").document(taskUid).set(taskDB)

        }

    }

    fun chageSelected(
        selectedNew: String
    ){
        var taskField2 = mutableListOf<EditTaskField>()
        state.taskFields.forEach{
            if (it.taskFieldName == selectedNew){
                taskField2.add(it.copy(select = true))
            }else{
                taskField2.add(it.copy(select = false))
            }
        }
        state.selectedTaskField = taskField2.find({it.taskFieldName == selectedNew})?.taskFieldName
        state = state.copy(
            taskFields = taskField2
        )
    }

    fun changeTasktitle(
        newTitile: String
    ){
        val task1 = state.task.copy(
            title = newTitile
        )
        state = state.copy(
            task = task1.copy()
        )
    }

    fun changeTaskDescrip(
        newDescription: String
    ){
        val task1 = state.task.copy(
            description = newDescription
        )
        state = state.copy(
            task = task1.copy()
        )
    }

    fun changeDate(
        day: Int,
        month: Int,
        year: Int
    ){
        val task1 = state.task.copy(
            day = day,
            month = month,
            year = year
        )
        state = state.copy(
            task = task1
        )
        currentDate()
    }

    private fun currentDate(){
        if (state.task.day != null && state.task.month != null && state.task.year != null){
            currentDate = "${state.task.day}/${if (state.task.month!! <10) "0"+state.task.month.toString() else state.task.month}/${state.task.year}"
        }
    }

}