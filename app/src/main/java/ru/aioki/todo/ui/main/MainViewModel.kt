package ru.aioki.todo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.aioki.todo.data.domain.TodoDomain
import ru.aioki.todo.data.repository.TodoRepository
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TodoRepository,
) : ViewModel() {

    val todoList = repository.getLiveData()

    fun test() {
        viewModelScope.launch {
            repository.create(
                "Title_${UUID.randomUUID().toString().takeLast(10)}",
                "${UUID.randomUUID()}"
            )
        }
    }

    fun update(todoDomain: TodoDomain) {
        viewModelScope.launch {
            repository.update(todoDomain)
        }
    }
}