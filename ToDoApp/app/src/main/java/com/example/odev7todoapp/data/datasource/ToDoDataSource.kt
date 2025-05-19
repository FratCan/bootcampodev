package com.example.odev7todoapp.data.datasource

import com.example.odev7todoapp.data.entity.ToDo
import com.example.odev7todoapp.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var toDosDao: ToDoDao) {

    suspend fun kaydet(name: String){
        val yeniTodo = ToDo(0,name)
        toDosDao.kaydet(yeniTodo)
    }


    suspend fun guncelle(id:Int,name: String){
        val guncellenenToDo = ToDo(id,name)
        toDosDao.guncelle(guncellenenToDo)
    }

    suspend fun sil(id:Int){
        val silinenToDo=ToDo(id,"")
        toDosDao.sil(silinenToDo)
    }

    suspend fun toDosyukle(): List<ToDo> = withContext(Dispatchers.IO){
        return@withContext toDosDao.toDosYukle()
    }

    suspend fun ara(aramakelimesi:String): List<ToDo> = withContext(Dispatchers.IO){
        return@withContext toDosDao.ara(aramakelimesi)
    }
}