package ru.aioki.todo.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.aioki.todo.data.local.model.TodoRoomModel

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoRoomModel: TodoRoomModel)

    @Delete
    suspend fun delete(todoRoomModel: TodoRoomModel)

    @Update
    suspend fun update(todoRoomModel: TodoRoomModel)

    @Query("SELECT * from todo")
    fun getLiveData(): LiveData<List<TodoRoomModel>>

    @Query("SELECT * from todo")
    suspend fun get(): List<TodoRoomModel>

}