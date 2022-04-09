package com.ebookfrenzy.carddemo
//import androidx.lifecycle.viewModel
import androidx.lifecycle.SavedStateHandle
import java.util.ArrayList
import kotlin.random.Random

class MainViewModel {
    val data = Data()


    companion object {
        var arr: ArrayList<ArrayList<Int>> = arrayListOf()
    }

    fun test() {
        val num = 7
        var i = 0
        while (i <= num) {



                arr.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
                i++

        }



    }
}