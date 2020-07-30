package com.sergo_smyk.singlelifecycleclicklistener.listener

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.LifecycleObserver

class SingleTimerClickListener(
    private val delayTime: Long,
    private val action: (View) -> Unit
) : LifecycleObserver, SingleClickListener() {

    override fun onSingleClick(view: View) {
        super.onSingleClick(view)
        registerUnlockEvent()
        action.invoke(view)
    }

    private fun registerUnlockEvent() {
        Handler(Looper.getMainLooper())
            .postDelayed(::forceUnlockEventsListener, delayTime)
    }
}