package com.example.odev7todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.odev7todoapp.data.entity.ToDo


@Database(entities = [ToDo::class], version = 1)
abstract class Veritabani: RoomDatabase() {
    abstract fun getToDosDao():ToDoDao
}