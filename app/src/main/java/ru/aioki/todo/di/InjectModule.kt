package ru.aioki.todo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.aioki.todo.data.local.AppDatabase
import ru.aioki.todo.data.local.dao.TodoDao
import ru.aioki.todo.data.repository.TodoRepository
import ru.aioki.todo.data.repository.TodoRepositoryLocalImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InjectModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context) = context

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    //------------------------Dao------------------------

    @Singleton
    @Provides
    fun provideTodoDao(database: AppDatabase) = database.todoDao()


    @Singleton
    @Provides
    fun provideTodoRepository(
        todoDao: TodoDao
    ): TodoRepository = TodoRepositoryLocalImpl(todoDao)

}