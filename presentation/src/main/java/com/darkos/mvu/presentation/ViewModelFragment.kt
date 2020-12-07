package com.darkos.mvu.presentation

import org.kodein.di.DI

abstract class ViewModelFragment: DIFragment() {

    override val fragmentDI: DI.Module by lazy {
        DI.Module(fragmentTag){
            bindViewModel<>()
        }
    }
}