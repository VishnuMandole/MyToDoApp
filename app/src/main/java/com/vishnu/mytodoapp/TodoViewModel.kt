package com.vishnu.mytodoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val repo: TodoRepository) : ViewModel() {

    val todos = repo.todos

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    fun onTitleChange(newTitle: String) {
        _title.value = newTitle
    }

    fun addTodo() = viewModelScope.launch {
        if (title.value.isNotBlank()) {
            repo.insert(TodoEntity(title = title.value))
            _title.value = ""
        }
    }

    fun update(todo: TodoEntity) = viewModelScope.launch {
        repo.update(todo)
    }

    fun delete(todo: TodoEntity) = viewModelScope.launch {
        repo.delete(todo)
    }
}
