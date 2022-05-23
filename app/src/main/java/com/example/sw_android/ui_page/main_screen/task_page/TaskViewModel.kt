package com.example.sw_android.ui_page.main_screen.task_page

import android.content.ContentValues.TAG
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

data class UiStateTaskScreen(
    var taskFields: MutableList<String> = mutableListOf(),
    var tasks: MutableList<TaskDB> = mutableListOf()
)

class TaskViewModel(
    private val auth: FirebaseAuth
) : ViewModel() {

    var state by mutableStateOf(UiStateTaskScreen())
    private var db = Firebase.firestore
    var isLoading = false

    init {
        refreshData()
    }

    fun refreshData() {
        auth!!.uid?.let {
            db.collection("WorkField").document(it).get().addOnSuccessListener { snapshot ->

                if (snapshot != null && snapshot.exists()) {
                    var TaskFields = snapshot.toObject<TaskFields>()
                    state = state.copy(
                        taskFields = TaskFields?.taskFields as MutableList<String>
                    )
                }
            }
            db.collection("Task").whereEqualTo("userUid",auth.uid).get().addOnSuccessListener{ documents ->
                if (documents != null) {
                    var task1 = mutableListOf<TaskDB>()
                    for (document in documents){
                        task1!!.add(document.toObject<TaskDB>().copy(TaskUid = document.id))
                    }
                    state = state.copy(
                        tasks = task1
                    )
                }
            }
        }
        if (!isLoading){
            isLoading = true
        }
    }

    fun deletTaskField(nameField: String){
        auth.uid?.let {
            db.collection("WorkField").document(it).set(TaskFields(state.taskFields.filter { it!= nameField }))
        }
        val delTask = mutableListOf<String>()
        db.collection("Task").whereEqualTo("userUid",auth.uid).whereEqualTo("taskField",nameField).get().addOnSuccessListener {
            for (document in it){
                delTask.add(document.id)
            }
            for (task in delTask){
                db.collection("Task").document(task).delete()
            }
        }
        refreshData()
    }

    fun setWorkFieldName(
        nameField: String
    ){
        if (state.taskFields == null){
            state = state.copy(
                taskFields = mutableListOf(nameField)
            )
        }
        else{
            state.taskFields!!.add(nameField)
        }
        val TaskFields = TaskFields(state.taskFields)
        auth!!.uid?.let { db.collection("WorkField").document(it).set(TaskFields) }
        refreshData()
    }

    fun getCurrentDate(
        month: Int,
    ): String{
        val months = listOf("январь", "февраль","март","апрель","май","июнь","июль","август","сентябрь", "октябрь", "ноябрь", "декабрь")
        return months[month]
    }
}