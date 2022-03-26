package com.ebookfrenzy.lifecycledemo.ui.main



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {

    companion object{

        var valueN: MutableLiveData<String> = MutableLiveData()
        var mess = ""

        fun test(msg : String){
            mess += msg
            valueN.value = mess



        }
    }

}