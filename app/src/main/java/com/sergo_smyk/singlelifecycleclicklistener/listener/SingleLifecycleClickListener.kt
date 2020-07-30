package com.sergo_smyk.singlelifecycleclicklistener.listener

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class SingleLifecycleClickListener(
    lifecycle: Lifecycle,
    private val action: (View) -> Unit
) : LifecycleObserver, SingleClickListener() {

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun unlockEvent() {
        forceUnlockEventsListener()
    }

    override fun onSingleClick(view: View) {
        super.onSingleClick(view)
        action.invoke(view)
    }
}