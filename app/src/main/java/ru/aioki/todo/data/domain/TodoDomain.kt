package ru.aioki.todo.data.domain

import ru.aioki.todo.data.local.model.TodoRoomModel


data class TodoDomain(
    val id: Int,
    val title: String,
    val text: String,
    var isFinished: Boolean = false
)

fun TodoRoomModel.toDomain() = TodoDomain(id, title, text, isFinished)

fun TodoDomain.toRoom() = TodoRoomModel(title, text, isFinished).apply {
    this.id = this@toRoom.id
}