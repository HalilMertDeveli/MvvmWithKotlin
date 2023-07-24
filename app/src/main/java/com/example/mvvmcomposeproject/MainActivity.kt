package com.example.mvvmcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmcomposeproject.ui.theme.MvvmComposeProjectTheme
import com.example.mvvmcomposeproject.ui.theme.add_edit_todo.AddEditTodoScreen
import com.example.mvvmcomposeproject.util.Routes
import com.plcoding.mvvmtodoapp.ui.todo_list.TodoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmComposeProjectTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.TODO_LIST) {
                    composable(Routes.TODO_LIST) {
                        TodoListScreen(onNavigate = { navController.navigate(it.route) })
                    }
                    composable(
                        route = Routes.ADD_EDIT_TODO + "?todoId={todoId}", arguments = listOf(
                            navArgument(name = "todoId") {
                                type= NavType.IntType
                                defaultValue=-1
                            })
                    ) {
                        AddEditTodoScreen(onPopBackStack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}
