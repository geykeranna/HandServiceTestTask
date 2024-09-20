package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell

interface GetOneEntityUseCase {
    fun execute(id: Long): Flow<Cell>
}