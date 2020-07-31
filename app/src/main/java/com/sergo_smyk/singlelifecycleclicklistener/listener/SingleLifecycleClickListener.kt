package com.sergo_smyk.singlelifecycleclicklistener.listener

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

sealed class SingleLifecycleClickListener(
    protected val lifecycle: Lifecycle,
    private val action: (View) -> Unit
) : LifecycleObserver, SingleClickListener() {

    abstract fun addObserver()

    override fun onSingleClick(view: View) {
        super.onSingleClick(view)
        action.invoke(view)
    }

    class OnStart(
        lifecycle: Lifecycle,
        action: (View) -> Unit
    ) : SingleLifecycleClickListener(lifecycle, action) {

        override fun addObserver() {
            lifecycle.addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private fun unlockLifecycleMethod() = forceUnlockEventsListener()
    }

    class OnResume(
        lifecycle: Lifecycle,
        action: (View) -> Unit
    ) : SingleLifecycleClickListener(lifecycle, action) {

        override fun addObserver() {
            lifecycle.addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        private fun unlockLifecycleMethod() = forceUnlockEventsListener()
    }

    class OnPause(
        lifecycle: Lifecycle,
        action: (View) -> Unit
    ) : SingleLifecycleClickListener(lifecycle, action) {

        override fun addObserver() {
            lifecycle.addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        private fun unlockLifecycleMethod() = forceUnlockEventsListener()
    }

    class OnStop(
        lifecycle: Lifecycle,
        action: (View) -> Unit
    ) : SingleLifecycleClickListener(lifecycle, action) {

        override fun addObserver() {
            lifecycle.addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        private fun unlockLifecycleMethod() = forceUnlockEventsListener()
    }
}