package com.dicoding.tasklist.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert
    suspend fun insertTask(todoModel: TodoModel): Long

    @Query("Select * from TodoModel where isFinished == 0")
    fun getTask(): LiveData<List<TodoModel>>

    @Delete
    suspend fun delete(task: TodoModel)
}