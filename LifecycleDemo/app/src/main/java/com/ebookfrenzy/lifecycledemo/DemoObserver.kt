@file:Suppress("DEPRECATION")

package com.ebookfrenzy.lifecycledemo

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


import com.ebookfrenzy.lifecycledemo.ui.main.MainViewModel
import java.util.*

class DemoObserver: LifecycleObserver {

    private var mv = MainViewModel
    @SuppressLint("SimpleDateFormat")
    val time = SimpleDateFormat("hh:mm:ss:mmm")
    val currentDate: Any = time.format(Date())

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){

        mv.test("onResume was fired on" + " " + currentDate+ "\n**************\n ")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){

        mv.test("onPause was fired on" + " " + currentDate+ "\n**************\n ")


    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){

        mv.test("onCreate was fired on" + " " + currentDate + "\n")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        mv.test("onStart was fired on" + " " + currentDate + "\n")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        mv.test("onStop was fired on" + " " + currentDate + "\n")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        mv.test("onDestroy was fired on" + " " + currentDate+ "\n**************\n ")

    }


}