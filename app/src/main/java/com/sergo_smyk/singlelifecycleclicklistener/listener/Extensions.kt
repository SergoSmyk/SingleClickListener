package com.sergo_smyk.singlelifecycleclicklistener.listener

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

object Extensions {

    fun View.setSingleLifecycleListener(
        lifecycle: Lifecycle,
        action: (View) -> Unit
    ): SingleLifecycleClickListener {
        val listener = SingleLifecycleClickListener(lifecycle, action)
        this.setOnClickListener(listener)
        return listener
    }

    fun View.setSingleLifecycleListener(
        lifecycleOwner: LifecycleOwner,
        action: (View) -> Unit
    ): SingleLifecycleClickListener {
        return this.setSingleLifecycleListener(lifecycleOwner.lifecycle, action)
    }

    fun View.setSingleTimerClickListener(
        delayTime: Long,
        action: (View) -> Unit
    ): SingleTimerClickListener {
        val listener = SingleTimerClickListener(delayTime, action)
        this.setOnClickListener(listener)
        return listener
    }
}