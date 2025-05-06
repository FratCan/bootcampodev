package com.example.navigationcomponentodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponentodev4.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.buttonGitA.setOnClickListener {
            val git = AnasayfaFragmentDirections.AGecis()
            Navigation.findNavController(it).navigate(git)
        }

        binding.buttonGitX.setOnClickListener {
            val git = AnasayfaFragmentDirections.XGecis()
            Navigation.findNavController(it).navigate(git)
        }

        return binding.root

    }


}