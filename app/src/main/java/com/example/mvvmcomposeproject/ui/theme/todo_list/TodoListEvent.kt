package com.example.mvvmcomposeproject.ui.theme.todo_list

import com.example.mvvmcomposeproject.data.Todo

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()



}
