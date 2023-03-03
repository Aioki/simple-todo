package ru.aioki.todo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.aioki.todo.data.domain.TodoDomain
import ru.aioki.todo.data.domain.toDomain
import ru.aioki.todo.data.domain.toRoom
import ru.aioki.todo.data.local.dao.TodoDao
import ru.aioki.todo.data.local.model.TodoRoomModel
import javax.inject.Inject

class TodoRepositoryLocalImpl @Inject constructor(
    private val localDao: TodoDao,
) : TodoRepository {

    override suspend fun create(title: String, text: String) {
        withContext(Dispatchers.IO) {
            localDao.insert(TodoRoomModel(title, text, false))
        }
    }

    override suspend fun delete(todoDomain: TodoDomain) {
        withContext(Dispatchers.IO) {
            localDao.delete(todoDomain.toRoom())
        }
    }

    override fun getLiveData(): LiveData<List<TodoDomain>> {
        return localDao.getLiveData().map { model -> model.map { it.toDomain() } }
    }

    override suspend fun update(todoDomain: TodoDomain) {
        withContext(Dispatchers.IO) {
            localDao.update(todoDomain.toRoom())
        }
    }

    override suspend fun get(): List<TodoDomain> {
        return withContext(Dispatchers.IO) {
            localDao.get().map { model -> model.toDomain() }
        }
    }
}