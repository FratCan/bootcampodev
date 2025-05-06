package com.example.navigationcomponentodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponentodev4.databinding.FragmentSayfaABinding
import com.example.navigationcomponentodev4.databinding.FragmentSayfaXBinding


class SayfaXFragment : Fragment() {

    private lateinit var binding:FragmentSayfaXBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSayfaXBinding.inflate(inflater,container,false)

        binding.buttonGitY.setOnClickListener {
            val git = SayfaXFragmentDirections.YGecis2()
            Navigation.findNavController(it).navigate(git)
        }
            return binding.root
    }


}