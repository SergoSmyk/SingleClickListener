package com.sergo_smyk.singlelifecycleclicklistener.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sergo_smyk.singlelifecycleclicklistener.R
import com.sergo_smyk.singlelifecycleclicklistener.listener.Extensions.setSingleLifecycleListener
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    private var clickCount = 0

    private var lastToast: Toast? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        message.text = "View clicked $clickCount times"

        val listener = button.setSingleLifecycleListener(this) {
            clickCount++
            message.text = "View clicked $clickCount times"
        }

        button2.setOnClickListener {
            listener.forceUnlockEventsListener()
            lastToast?.cancel()
            lastToast = Toast.makeText(context, "Click unlocked", Toast.LENGTH_SHORT).apply {
                show()
            }
        }
    }
}