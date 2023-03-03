package ru.aioki.todo.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.aioki.todo.data.repository.TodoRepository
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: TodoRepository,
) : ViewModel() {

    fun add(title: String, text: String){
        viewModelScope.launch {
            repository.create(title, text)
        }
    }
}