package com.example.mvvmcomposeproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todo(
    val title: String,

    val description: String?,

    val isDone: Boolean = false,

    @PrimaryKey val id: Int? = null

) {
}