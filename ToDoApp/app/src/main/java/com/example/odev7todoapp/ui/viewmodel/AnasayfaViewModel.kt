package com.example.odev7todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7todoapp.data.entity.ToDo
import com.example.odev7todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor( var toDoRepository: ToDoRepository) : ViewModel() {

    var toDoList = MutableLiveData<List<ToDo>>()

    init {
        toDosYukle()
    }

    fun sil(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.sil(id)
            toDosYukle()
        }
    }

    fun toDosYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value=toDoRepository.toDosYukle()      // tetikliyoruz.
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {               //tetikleme
            toDoList.value=toDoRepository.ara(aramaKelimesi)
        }
    }
}