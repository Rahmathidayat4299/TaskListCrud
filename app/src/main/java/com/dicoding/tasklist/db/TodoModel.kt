package com.dicoding.tasklist.db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class TodoModel(
    var namaBarang: String,
    var description: String,
    var banyakBarang: String,
    var date: Long,
    var time: Long,
    var isFinished: Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
)