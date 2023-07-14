package com.example.mvvmcomposeproject.ui.theme.todo_list

import androidx.lifecycle.ViewModel
import com.example.mvvmcomposeproject.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
):ViewModel() {

}