package com.dicoding.tasklist.util

import android.content.Context
import androidx.lifecycle.LiveData
import com.dicoding.tasklist.db.AppDatabase
import com.dicoding.tasklist.db.TodoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repository {
    companion object {
        private var appDb: AppDatabase? = null

        private fun initizalizeDb(context: Context): AppDatabase {
            return AppDatabase.getDatabase(context)
        }

        fun insert(context: Context, task: TodoModel) {
            appDb = initizalizeDb(context)
            CoroutineScope(IO).launch {
                appDb?.todoDao()?.insertTask(task)
            }
        }

        fun getList(context: Context): LiveData<List<TodoModel>>? {
            appDb = initizalizeDb(context)
            return appDb?.todoDao()?.getTask()
        }

        fun deleteTask(context: Context, task: TodoModel) {
            appDb = initizalizeDb(context)
            CoroutineScope(IO).launch {
                appDb?.todoDao()?.delete(task)
            }
        }
    }
}