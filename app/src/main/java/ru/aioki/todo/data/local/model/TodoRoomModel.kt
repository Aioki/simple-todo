package ru.aioki.todo.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoRoomModel(
    val title: String,
    val text: String,
    val isFinished: Boolean,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}


