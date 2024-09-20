package ru.testtask.handservice.ui.screens.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.models.CellState
import ru.testtask.handservice.domain.usecases.CreateEntityUseCase
import ru.testtask.handservice.domain.usecases.GetAllEntityUseCase
import ru.testtask.handservice.ui.base.BaseEvent
import ru.testtask.handservice.ui.base.BaseViewModel

class MainScreenViewModel(
    private val getAllEntityUseCase: GetAllEntityUseCase,
    private val createEntityUseCase: CreateEntityUseCase,
) : BaseViewModel<MainScreenViewModel.Event>() {
    private val _data = MutableStateFlow<List<Cell>>(listOf())
    private val data: StateFlow<List<Cell>> = _data

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getData(): StateFlow<List<Cell>> = data

    private fun startLoading() = viewModelScope.launch {
        getAllEntityUseCase.execute().collect { dataList ->
            _data.emit(dataList)
        }
    }

    private fun createNewEntity() = viewModelScope.launch {
        createEntityUseCase.execute(data.value)
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        data object OnAddItems: Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnAddItems -> {
                createNewEntity()
            }
        }
    }
}