package com.dicoding.tasklist.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.tasklist.util.Repository
import com.dicoding.tasklist.db.TodoModel

class TodoViewModel : ViewModel() {
    fun insertTask(context: Context, task: TodoModel) {
        Repository.insert(context, task)
    }

    fun getListTask(context: Context): LiveData<List<TodoModel>>? {
        return Repository.getList(context)
    }

    fun deleteTask(context: Context, task: TodoModel) {
        Repository.deleteTask(context, task)
    }
}