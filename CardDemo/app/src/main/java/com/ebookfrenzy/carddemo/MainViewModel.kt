package com.ebookfrenzy.carddemo
//import androidx.lifecycle.viewModel
import androidx.lifecycle.SavedStateHandle
import java.util.ArrayList
import kotlin.random.Random

class MainViewModel {
    val data = Data()
    /*var m = Array(7) {Array(7) {0;1;2;3;4;5;6;7} }
    var n = arrayListOf<Data>()*/
//companion object intlist arraylist



    companion object {
       var arr: ArrayList<ArrayList<Int>> = arrayListOf()
    }
   // val intlist = ArrayList<Int>()

   /* var intlist = ArrayList<Int>()*/
   fun test(){
    val num = 7
        var i =0
    while(i <= num) {
        arr.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
        i++
    }
    }
/*    var arr = arrayOf(arrayOf(data.titles), arrayOf(data.details), arrayOf(data.images))
    val rand = List(7) { Random.Default.nextInt(arr)}*/


}