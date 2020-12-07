package com.darkos.mvu.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import org.kodein.di.*

inline fun <reified T : ViewModel> DI.Builder.bindViewModel(overrides: Boolean? = null): DI.Builder.TypeBinder<T> {
    return bind<T>(T::class.java.simpleName, overrides)
}

inline fun <T, reified VM : ViewModel> T.viewModel(): Lazy<VM>
        where T : DIAware,
              T : Fragment {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM>
        where T : DIAware,
              T : FragmentActivity {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}