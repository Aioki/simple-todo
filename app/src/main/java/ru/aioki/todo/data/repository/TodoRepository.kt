package ru.aioki.todo.data.repository

import androidx.lifecycle.LiveData
import ru.aioki.todo.data.domain.TodoDomain

interface TodoRepository {

    suspend fun create(title: String, text: String)

    suspend fun delete(todoDomain: TodoDomain)

    suspend fun update(todoDomain: TodoDomain)

    fun getLiveData(): LiveData<List<TodoDomain>>

    suspend fun get(): List<TodoDomain>

}