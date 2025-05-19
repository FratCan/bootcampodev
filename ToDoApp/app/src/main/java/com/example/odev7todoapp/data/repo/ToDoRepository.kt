package com.example.odev7todoapp.data.repo

import com.example.odev7todoapp.data.datasource.ToDoDataSource
import com.example.odev7todoapp.data.entity.ToDo

class ToDoRepository(var toDosDataSource: ToDoDataSource) {

    suspend fun kaydet(name: String){
        toDosDataSource.kaydet(name)
    }

    suspend fun guncelle(id: Int,name: String){
        toDosDataSource.guncelle(id,name)
    }

    suspend fun sil(id:Int){
        toDosDataSource.sil(id)
    }

    suspend fun toDosYukle(): List<ToDo> = toDosDataSource.toDosyukle()

    suspend fun ara(aramaKelimesi: String): List<ToDo> = toDosDataSource.ara(aramaKelimesi)
}