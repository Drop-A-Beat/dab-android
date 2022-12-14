package com.dab.android.core.common.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any>(initialState: STATE): ContainerHost<STATE, SIDE_EFFECT>, ViewModel() {
    final override val container: Container<STATE, SIDE_EFFECT> by lazy { container(initialState) }

    val uiState: StateFlow<STATE> = container.stateFlow

    val uiSideEffect: Flow<SIDE_EFFECT> = container.sideEffectFlow
}
