package com.darkos.mvu.presentation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.darkos.mvu.model.MVUState
import kotlinx.coroutines.flow.StateFlow

class BaseViewModel<C : MVUComponent<T>, T : MVUState>(
    val component: C
) : ViewModel() {

    val state: StateFlow<T>
        get() = component.state

    private var isInitialized = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onCreate() {
        if (isInitialized.not()) {
            isInitialized = true
            component.start()
        }
    }

    override fun onCleared() {
        component.clear()
        super.onCleared()
    }
}