package com.ebookfrenzy.lifecycledemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner

import com.ebookfrenzy.lifecycledemo.ui.main.MainViewModel

class DemoObserver: LifecycleObserver {

    private var mv = MainViewModel

    private val LOG_TAG = "DemoObserver"
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        //Log.i(LOG_TAG,"onResume")
        mv.test("onResume was fired on")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
       // Log.i(LOG_TAG,"onPause")
        mv.test("onPause was fired on")


    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        //Log.i(LOG_TAG,"onCreate")
        mv.test("onCreate was fired on")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        mv.test("onStart was fired on")
        //Log.i(LOG_TAG,"onStart")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        mv.test("onStop was fired on")
        //Log.i(LOG_TAG,"onStop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        mv.test("onDestroy was fired on")
    //Log.i(LOG_TAG,"onDestroy")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner:LifecycleOwner, event:Lifecycle.Event){
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
    }
}