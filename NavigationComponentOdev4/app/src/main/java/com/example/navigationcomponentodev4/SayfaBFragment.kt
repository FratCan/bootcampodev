package com.example.navigationcomponentodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponentodev4.databinding.FragmentSayfaBBinding


class SayfaBFragment : Fragment() {

    private lateinit var binding: FragmentSayfaBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSayfaBBinding.inflate(inflater,container,false)

        binding.buttonGitY2.setOnClickListener {
            val git = SayfaBFragmentDirections.YGecis1()
            Navigation.findNavController(it).navigate(git)
        }
        return binding.root
    }


}