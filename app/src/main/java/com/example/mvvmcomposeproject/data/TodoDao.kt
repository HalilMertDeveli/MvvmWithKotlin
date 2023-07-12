package com.example.mvvmcomposeproject.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //if there is same id number in adding new todo
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id: Int): Todo?

    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>> //we are getting all todos
}