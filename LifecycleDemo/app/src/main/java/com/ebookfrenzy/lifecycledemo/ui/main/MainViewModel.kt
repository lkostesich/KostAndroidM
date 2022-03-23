package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //mutable live data object that will store a string concatenation of all messages
    companion object{
        //mutable live data has to got here
        var result: MutableLiveData<String> = MutableLiveData()
        var valueN: MutableLiveData<String> = MutableLiveData()
        var mess = ""
        fun test(msg : String){
            mess += msg
            valueN.setValue(mess)

        }
    }

    //method to call that will return mutible live data object
}