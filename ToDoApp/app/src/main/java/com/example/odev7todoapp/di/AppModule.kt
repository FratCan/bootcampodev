package com.example.odev7todoapp.di


import android.content.Context
import androidx.room.Room
import com.example.odev7todoapp.data.datasource.ToDoDataSource
import com.example.odev7todoapp.data.repo.ToDoRepository
import com.example.odev7todoapp.room.ToDoDao
import com.example.odev7todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDoRepository(toDoDataSource: ToDoDataSource): ToDoRepository{
        return ToDoRepository(toDoDataSource)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao): ToDoDataSource{
        return ToDoDataSource(toDoDao)
    }


    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context) : ToDoDao {
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"todo.sqlite")
            .createFromAsset("todo.sqlite")
            .build()
        return veritabani.getToDosDao()
    }



}