package com.example.odev7todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.odev7todoapp.R
import com.example.odev7todoapp.databinding.FragmentAnasayfaBinding
import com.example.odev7todoapp.databinding.FragmentDetaySayfaBinding
import com.example.odev7todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.odev7todoapp.ui.viewmodel.DetaySayfaViewModel
import com.example.odev7todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetaySayfaFragment : Fragment() {
    private lateinit var binding: FragmentDetaySayfaBinding
    private lateinit var viewModel: DetaySayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentDetaySayfaBinding.inflate(inflater,container,false)
        val bundle : DetaySayfaFragmentArgs by navArgs()
        val gelenToDo = bundle.todo

        binding.editTextToDo.setText(gelenToDo.name)

        binding.buttonGuncelle.setOnClickListener {
            val name=binding.editTextToDo.text.toString()
            Navigation.gecisYap(it,R.id.anasayfaFragment)
            viewModel.guncelle(gelenToDo.id,name)
        }


        val geriTusu = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.e("Detay sayfa", "Geri tuşu çalıştı")
                Navigation.findNavController(requireView())
                    .navigate(R.id.anasayfaFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, geriTusu)






        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetaySayfaViewModel by viewModels()
        viewModel = tempViewModel
    }


}