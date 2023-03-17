package com.example.json.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.json.model.Todo
import com.example.json.ui.theme.JSONTheme
import com.example.json.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JSONTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ToDoScreen()
                }
            }
        }
    }
}

@Composable
fun ToDoScreen(todoViewModel: TodoViewModel = viewModel()) {
    ToDoList(todoViewModel.todos)
}

@Composable
fun ToDoList(todos: List<Todo>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ){
        items(todos) {todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp,bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}