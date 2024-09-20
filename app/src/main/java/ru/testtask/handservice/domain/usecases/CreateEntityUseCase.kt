package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell

interface CreateEntityUseCase {
    suspend fun execute(exist: List<Cell>): Flow<Boolean>
}