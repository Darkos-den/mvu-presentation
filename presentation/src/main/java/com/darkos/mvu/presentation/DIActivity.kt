package com.darkos.mvu.presentation

import android.app.Activity
import android.os.Bundle
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.android.di
import org.kodein.di.android.retainedSubDI

abstract class DIActivity: Activity(), DIAware {

    abstract val activityTag: String

    override val di: DI by retainedSubDI(di()) {
        import(activityDI)
    }

    open val activityDI: DI.Module by lazy {
        DI.Module(activityTag){}
    }

    override val diTrigger = DITrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diTrigger.trigger()
    }
}