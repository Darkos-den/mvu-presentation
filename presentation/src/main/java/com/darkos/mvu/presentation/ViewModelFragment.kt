package com.darkos.mvu.presentation

import com.darkos.mvu.EffectHandler
import com.darkos.mvu.Reducer
import com.darkos.mvu.model.*
import com.darkos.mvu.model.flow.FlowEffect
import com.darkos.mvu.model.flow.FlowMessage
import kotlinx.coroutines.flow.Flow
import org.kodein.di.DI
import org.kodein.di.instance
import org.kodein.di.provider


data class SampleState(
    val email: String
): MVUState()

class SampleComponent: MVUComponent<SampleState>(
    reducer = object : Reducer<SampleState> {
        override fun update(state: SampleState, message: Message): StateCmdData<SampleState> {
            TODO("Not yet implemented")
        }
    },
    effectHandler = object : EffectHandler {
        override suspend fun call(effect: Effect): Message {
            TODO("Not yet implemented")
        }

        override suspend fun call(effect: FlowEffect): Flow<FlowMessage> {
            TODO("Not yet implemented")
        }
    }
){

    fun onClick(){
        program.accept(Idle)
    }

    override fun createInitialState(): SampleState {
        return SampleState("")
    }

}

abstract class ViewModelFragment: DIFragment() {

    override val fragmentDI: DI.Module by lazy {
        DI.Module(fragmentTag){
            bindViewModel<BaseViewModel<SampleComponent, SampleState>>() with provider {
                BaseViewModel(instance())
            }
        }
    }

    private val viewModel: BaseViewModel<SampleComponent, SampleState> by viewModel()

    fun onClick(){
        viewModel.component.onClick()
    }
}