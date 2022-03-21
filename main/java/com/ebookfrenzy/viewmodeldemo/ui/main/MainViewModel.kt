package com.ebookfrenzy.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {


    var dollarValue: MutableLiveData<String> = MutableLiveData()
    var result: MutableLiveData<Float> = MutableLiveData()
    var name: MutableLiveData<String> = MutableLiveData()

    fun addName(nm: String){
        val nme = " " + nm
        name.value = nme
    }
    fun convertValue() {
        dollarValue.let {
            val nme = " " + dollarValue
            name.value = nme

        }
    }
}




