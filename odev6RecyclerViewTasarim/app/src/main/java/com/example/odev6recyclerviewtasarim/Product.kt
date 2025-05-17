package com.example.odev6recyclerviewtasarim

import android.R

data class Product(var id:Int,var aciklama: String,var resim: String,var fiyat:Int, var isFavorite: Boolean = false) {
}