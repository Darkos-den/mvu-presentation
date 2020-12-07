package com.darkos.mvu.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.android.subDI
import org.kodein.di.android.x.di

abstract class DIFragment : Fragment(), DIAware {

    abstract val fragmentTag: String

    override val di by subDI(di()) {
        import(fragmentDI)
    }

    open val fragmentDI: DI.Module by lazy {
        DI.Module(fragmentTag) {}
    }

    override val diTrigger = DITrigger()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        diTrigger.trigger()
    }
}