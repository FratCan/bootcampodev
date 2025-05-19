package com.example.odev7todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.odev7todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetaySayfaViewModel @Inject constructor(var toDoRepository: ToDoRepository): ViewModel() {

    fun guncelle(id: Int,name: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.guncelle(id,name)
        }
    }
}