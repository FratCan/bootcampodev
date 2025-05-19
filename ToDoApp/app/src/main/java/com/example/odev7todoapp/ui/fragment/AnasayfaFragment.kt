package com.example.odev7todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odev7todoapp.R
import com.example.odev7todoapp.data.entity.ToDo
import com.example.odev7todoapp.databinding.FragmentAnasayfaBinding
import com.example.odev7todoapp.ui.adapter.ToDoAdapter
import com.example.odev7todoapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.odev7todoapp.utils.gecisYap

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.eklemeButton.setOnClickListener {
            Navigation.gecisYap(it,R.id.anasayfatokayitsayfa)
        }

        viewModel.toDoList.observe(viewLifecycleOwner) {
            val toDosAdapter = ToDoAdapter(requireContext(),it,viewModel)      //dinliyoruz
            binding.todoRv.adapter = toDosAdapter
        }

        binding.todoRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)          //harf girince ve silince
                return  true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)            //ara butonuna basınca
                return true
            }
        })


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.toDosYukle()
    }

}