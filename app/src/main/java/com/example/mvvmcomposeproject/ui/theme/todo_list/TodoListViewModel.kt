package com.example.mvvmcomposeproject.ui.theme.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcomposeproject.data.Todo
import com.example.mvvmcomposeproject.data.TodoRepository
import com.example.mvvmcomposeproject.util.Routes
import com.example.mvvmcomposeproject.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
):ViewModel() {

    val todos =  repository.getTodos()

    private val _uiEvent = Channel<UiEvent>()

    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: TodoListEvent){
        when(event){

            is TodoListEvent.OnDeleteTodoClick ->{

            }
            is TodoListEvent.OnUndoDeleteClick->{

            }
            is TodoListEvent.OnDoneChange ->{
                viewModelScope.launch {
                    repository.insertTodo(
                        event.todo,//we cant figure out
                    )
                }
            }
            is TodoListEvent.OnTodoClick ->{
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO +"?todoId=${event.todo.id}"))
            }
            is  TodoListEvent.OnAddToDoClick->{
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO))
            }
        }
    }

    private fun sendUiEvent(event:UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }

    }

}