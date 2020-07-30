package com.sergo_smyk.singlelifecycleclicklistener.listener

import android.view.View
import androidx.annotation.CallSuper
import java.util.concurrent.atomic.AtomicBoolean

abstract class SingleClickListener : View.OnClickListener {

    private var isAlreadyClicked = AtomicBoolean(false)

    fun forceUnlockEventsListener() {
        isAlreadyClicked.set(false)
    }

    @CallSuper
    open fun onSingleClick(view: View) {
        isAlreadyClicked.set(true)
    }

    final override fun onClick(view: View) {
        if (isAlreadyClicked.get()) {
            return
        }
        onSingleClick(view)
    }
}