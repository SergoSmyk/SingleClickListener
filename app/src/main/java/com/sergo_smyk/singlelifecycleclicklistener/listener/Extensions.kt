package com.sergo_smyk.singlelifecycleclicklistener.listener

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object Extensions {

    fun View.setSingleLifecycleListener(
        lifecycle: Lifecycle,
        unlockEvent: Lifecycle.Event = Lifecycle.Event.ON_RESUME,
        action: (View) -> Unit
    ): SingleLifecycleClickListener {

        val listener = when (unlockEvent) {
            Lifecycle.Event.ON_START -> SingleLifecycleClickListener.OnStart(lifecycle, action)
            Lifecycle.Event.ON_RESUME -> SingleLifecycleClickListener.OnResume(lifecycle, action)
            Lifecycle.Event.ON_PAUSE -> SingleLifecycleClickListener.OnPause(lifecycle, action)
            Lifecycle.Event.ON_STOP -> SingleLifecycleClickListener.OnStop(lifecycle, action)
            else -> throw ClassCastException("Cannot use this event type for listener")
        }
        this.setOnClickListener(listener)
        return listener
    }

    fun View.setSingleLifecycleListener(
        lifecycleOwner: LifecycleOwner,
        unlockEvent: Lifecycle.Event = Lifecycle.Event.ON_RESUME,
        action: (View) -> Unit
    ): SingleLifecycleClickListener {
        return this.setSingleLifecycleListener(lifecycleOwner.lifecycle, unlockEvent, action)
    }

    fun View.setSingleTimerClickListener(
        delayTime: Long = 1000L,
        action: (View) -> Unit
    ): SingleTimerClickListener {
        val listener = SingleTimerClickListener(delayTime, action)
        this.setOnClickListener(listener)
        return listener
    }
}