package com.darkos.mvu.presentation

import androidx.lifecycle.ViewModel
import com.darkos.mvu.model.MVUState

class BaseViewModel<T : MVUState>(
    private val component: MVUComponent<T>
) : ViewModel() {

    override fun onCleared() {
        component.clear()
        super.onCleared()
    }
}