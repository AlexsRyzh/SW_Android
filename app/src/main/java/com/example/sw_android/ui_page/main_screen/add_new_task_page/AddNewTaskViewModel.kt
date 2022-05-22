package com.example.sw_android.ui_page.main_screen.add_new_task_page

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sw_android.model.TaskFields
import com.example.sw_android.ui_page.main_screen.task_page.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

data class addNewTaskUiState(
    var taskFields: MutableList<addNewTaskField> = mutableListOf(),
    var task: Task = Task(
        title = "",
        description = "",
        day = null,
        month = null,
        year = null
    )
)

data class addNewTaskField(
    var select: Boolean = false,
    var taskFieldName: String = ""
)


class AddNewTaskViewModel(
    private val auth: FirebaseAuth
): ViewModel(){

    var state by mutableStateOf(addNewTaskUiState())
    private var db = Firebase.firestore

    init {
        refreshTaskField()
    }

    private fun refreshTaskField(){
        auth.uid?.let {
            db.collection("WorkField").document(it).get().addOnSuccessListener { snapshot ->
                Log.d(ContentValues.TAG, "Current data1: ${snapshot.data}")
                var taskFiel2 = mutableListOf<addNewTaskField>()
                snapshot.toObject<TaskFields>()?.taskFields?.forEach { name ->
                    taskFiel2.add(addNewTaskField(false,name))
                }
                if (taskFiel2.size>0) {
                    taskFiel2[0].select=true
                }
                state = state.copy(taskFields = taskFiel2.filter { true } as MutableList<addNewTaskField>)
            }
        }
    }

    fun chageSelected(
        selectedNew: String
    ){
        var taskField2 = mutableListOf<addNewTaskField>()
        state.taskFields.forEach{
            taskField2.add(addNewTaskField(false,it.taskFieldName))
        }
        taskField2.find({it.taskFieldName == selectedNew})?.select = true
        state = state.copy(
            taskFields = taskField2
        )
    }

}