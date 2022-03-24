package com.ebookfrenzy.lifecycledemo.ui.main

import android.icu.text.SimpleDateFormat
import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.format.DateTimeFormatter
import java.util.*

class MainViewModel : ViewModel() {

    //mutable live data object that will store a string concatenation of all messages
    companion object{
        //mutable live data has to got here
        var valueN: MutableLiveData<String> = MutableLiveData()
        var mess = ""
        val time = SimpleDateFormat("hh:mm:ss:mmm")
        val currentDate = time.format(Date())
        fun test(msg : String){
            mess += msg
            valueN.setValue(mess)
            mess = mess + " " + currentDate+ "\n**************\n "


        }
    }

    //method to call that will return mutible live data object
}