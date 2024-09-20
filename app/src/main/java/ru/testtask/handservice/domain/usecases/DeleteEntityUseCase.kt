package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell

interface DeleteEntityUseCase {
    suspend fun execute(cell: Cell): Flow<Boolean>
}