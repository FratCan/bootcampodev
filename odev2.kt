package com.example.myapplication.odevler

fun main(){


    val odev2=odev2()
    println(odev2.donustur(38))
    odev2.hesapla(4,2)
    println(odev2.faktoriyel(0))
    println(odev2.kelime("araba"))
    println(odev2.icAciHesapla(3))
    println(odev2.maasHesapla(21))
    println(odev2.kota(51))
}

class odev2{
    //1
    fun donustur(deger:Int):Double{
        val sonuc=deger*1.8+32
        return sonuc
    }
    //2
    fun hesapla(en:Int,boy:Int){
        val sonuc=en*2+boy*2
        println(sonuc)
    }

    //3
    fun faktoriyel(sayi:Int):Int{

        var sonuc=1
        for(i in 1..sayi){
            sonuc*=i
        }
        return sonuc
    }

    //4
    fun kelime(sozcuk:String):Int{
        return sozcuk.count { it == 'a' || it == 'A' }
    }

    //5
    fun icAciHesapla(n:Int):Int{
        val sonuc=(n-2)*180
        return sonuc
    }

    //6
    val normalSaat = 8
    val normalUcret = 10
    val mesaiUcret = 20
    val mesaiSiniri = 160

    fun maasHesapla(gun:Int):Int{
       val toplamSaat=gun*normalSaat
        var toplamMaas=0

        if(toplamSaat>mesaiSiniri){
            val normal=mesaiSiniri
            val mesai= toplamSaat-mesaiSiniri
            toplamMaas=(mesai*mesaiUcret)+(normal*normalUcret)
        }
        else{
            toplamMaas=toplamSaat*normalUcret
        }
        return toplamMaas

    }

    //7
    val normall=2
    val asim=4
    var total=0

    fun kota(miktarr:Int):Int{
        if(miktarr>=50){
            total=((miktarr-50)*asim)+100
        }
        else{
            total=miktarr*normall
        }
        return  total

    }


}

