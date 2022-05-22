package com.example.sw_android.ui_page.main_screen.task_page

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sw_android.model.TaskFields
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

data class UiStateTaskScreen(
    var taskFields: MutableList<String> = mutableListOf(),
    var tasks: MutableMap<String, MutableList<Task>> = mutableMapOf()
)

data class Task(
    var title: String,
    var description:String,
    var day: Int?,
    var month: Int?,
    var year: Int?
)

class TaskViewModel(
    private val auth: FirebaseAuth
) : ViewModel() {

    var state by mutableStateOf(UiStateTaskScreen())
    private var db = Firebase.firestore

    init {
        refreshData()
    }

    private fun refreshData() {
        auth!!.uid?.let {
            db.collection("WorkField").document(it).addSnapshotListener { snapshot, e ->
                if (e !== null){
                Log.w(TAG, "listen:error", e)
                return@addSnapshotListener
                }

                if (snapshot != null && snapshot.exists()) {
                    val TaskFields = snapshot.toObject<TaskFields>()
                    state = state.copy(
                        taskFields = TaskFields!!.taskFields as MutableList<String>
                    )
                }

                if (snapshot != null && snapshot.exists()) {
                } else {
                    Log.d(TAG, "Current data: null")
                }
            }
        }
    }

    fun deletTaskField(nameField: String){
        auth.uid?.let {
            db.collection("WorkField").document(it).set(TaskFields(state.taskFields.filter { it!= nameField }))
        }
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
    }
}