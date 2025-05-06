package com.example.navigationcomponentodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponentodev4.databinding.FragmentAnasayfaBinding
import com.example.navigationcomponentodev4.databinding.FragmentSayfaABinding


class SayfaAFragment : Fragment() {

    private lateinit var binding: FragmentSayfaABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSayfaABinding.inflate(inflater,container,false)

        binding.buttonGitB.setOnClickListener {
            val git = SayfaAFragmentDirections.BGecis()
            Navigation.findNavController(it).navigate(git)
        }

        return binding.root
    }


}