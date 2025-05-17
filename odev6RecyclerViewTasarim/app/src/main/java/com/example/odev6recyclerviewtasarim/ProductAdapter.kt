package com.example.odev6recyclerviewtasarim

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6recyclerviewtasarim.databinding.CardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class ProductAdapter(var mContext:Context,var productList: List<Product>)
    : RecyclerView.Adapter<ProductAdapter.CardTasarimTutucu>() {


    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        var binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent ,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = productList[position]
        val t = holder.tasarim

        t.textViewFiyat.text = "${urun.fiyat} TL"
        t.textViewAciklama.text = "${urun.aciklama}"
        t.productView.setImageResource(
            mContext.resources.getIdentifier(urun.resim, "drawable", mContext.packageName)
        )

        val kalpRes = if (urun.isFavorite) {
            R.drawable.ic_heart_filled
        } else {
            R.drawable.ic_heart_outline
        }
        t.heartButton.setImageResource(kalpRes)

        t.heartButton.setOnClickListener {
            urun.isFavorite = !urun.isFavorite

            // Yeni durumu yansıt
            val yeniResim = if (urun.isFavorite) {
                R.drawable.ic_heart_filled
            } else {
                R.drawable.ic_heart_outline
            }

            t.heartButton.setImageResource(yeniResim)
        }
    }


    override fun getItemCount(): Int {
            return  productList.size
    }





}