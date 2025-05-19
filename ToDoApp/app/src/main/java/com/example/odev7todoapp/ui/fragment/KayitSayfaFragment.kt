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
import com.example.odev7todoapp.R
import com.example.odev7todoapp.databinding.FragmentKayitSayfaBinding
import com.example.odev7todoapp.ui.viewmodel.KayitSayfaViewModel
import com.example.odev7todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class KayitSayfaFragment : Fragment() {

    private lateinit var binding: FragmentKayitSayfaBinding
    private lateinit var viewModel: KayitSayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentKayitSayfaBinding.inflate(inflater,container,false)
        binding.buttonKaydet.setOnClickListener {
            val name = binding.kayittext.text.toString()
            viewModel.kaydet(name)
            Navigation.gecisYap(it,R.id.anasayfaFragment)
        }
        val geriTusu = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.e("Kayıt sayfa", "Geri tuşu çalıştı")
                Navigation.findNavController(requireView())
                    .navigate(R.id.anasayfaFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, geriTusu)



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitSayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
}