package com.ebookfrenzy.lifecycledemo
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.ebookfrenzy.lifecycledemo.ui.main.MainViewModel

class DemoOwner:LifecycleOwner {
    private val lifecycleRegistry:LifecycleRegistry
    init{
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycle.addObserver(DemoObserver())

    }

    fun startOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }
    fun stopOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }
    override fun getLifecycle():Lifecycle{
        return lifecycleRegistry
    }
}