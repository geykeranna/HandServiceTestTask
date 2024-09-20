package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.repository.CommonRepository

class DeleteEntityUseCaseImpl(
    private val repository: CommonRepository
): DeleteEntityUseCase {
    override suspend fun execute(cell: Cell): Flow<Boolean> {
        return repository.deleteEntity(cell = cell)
    }
}