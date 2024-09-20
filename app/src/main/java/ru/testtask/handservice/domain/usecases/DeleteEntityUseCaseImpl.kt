package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.repository.CommonRepository

class DeleteEntityUseCaseImpl(
    private val repository: CommonRepository
): DeleteEntityUseCase {
    override suspend fun execute(id: Long): Flow<Boolean> {
        return repository.deleteEntity(id = id)
    }
}