package com.example.odev6recyclerviewtasarim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6recyclerviewtasarim.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)


        val urunlerListesi = ArrayList<Product>()
        val p1 = Product(1,"Crocs","crocs",1412,false)
        val p2 = Product(2,"Mavi Gömlek Kısa Kol","mavi",785,false)
        val p3 = Product(3,"Guess Saat","saat",7200,false)
        val p4 = Product(4,"Mango Logo desenli Çanta","canta",999,false)
        val p5 = Product(5,"Armonika Kadın siyah Ceket","ceket",364,false)
        val p6 = Product(6,"Bargello Kadın Parfümü","parfum",400,false)
        urunlerListesi.add(p1)
        urunlerListesi.add(p2)
        urunlerListesi.add(p3)
        urunlerListesi.add(p4)
        urunlerListesi.add(p5)
        urunlerListesi.add(p6)

        val productFragment = ProductAdapter(requireContext(), urunlerListesi)
        binding.urunlerRv.adapter = productFragment

        binding.urunlerRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }


}