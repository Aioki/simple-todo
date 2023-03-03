package ru.aioki.todo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.aioki.todo.data.local.dao.TodoDao
import ru.aioki.todo.data.local.model.TodoRoomModel

@Database(
    version = 3,
    entities = [
        TodoRoomModel::class,
    ],
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {

        private const val DATASTORE_NAME = "konfetki_bd"

        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, DATASTORE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}