package com.example.odev7todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7todoapp.R
import com.example.odev7todoapp.data.entity.ToDo
import com.example.odev7todoapp.databinding.TodoTasarimBinding
import com.example.odev7todoapp.ui.fragment.AnasayfaFragment
import com.example.odev7todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.odev7todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.odev7todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar


class ToDoAdapter(var mContext: Context,
                  var toDoList: List<ToDo>,
                  var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<ToDoAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: TodoTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val tasarim = TodoTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(
        holder: CardTasarimTutucu,
        position: Int
    ) {
        val todo=toDoList.get(position)
        val t = holder.tasarim
        t.textViewToDo.text = todo.name

        t.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfatodetaysayfa(todo=todo)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${todo.name} silinsin mi ?" , Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(todo.id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
            return  toDoList.size
    }



}