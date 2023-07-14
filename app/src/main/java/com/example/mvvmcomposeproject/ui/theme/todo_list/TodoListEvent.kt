package com.example.mvvmcomposeproject.ui.theme.todo_list

import com.example.mvvmcomposeproject.data.Todo

sealed class TodoListEvent() {
    data class OnDeleteTodoClick(val todo: Todo) : TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean) : TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo:Todo):TodoListEvent()//i guest return thing would be data class
    object OnAddToDoClick:TodoListEvent() //i guest unit operation would be object
}
