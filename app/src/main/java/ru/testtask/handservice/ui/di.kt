package ru.testtask.handservice.ui

import ru.testtask.handservice.ui.screens.main.MainScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiDi = module {
    viewModelOf(::MainScreenViewModel)
}