package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.repository.CommonRepository

class GetAllEntityUseCaseImpl(
    private val repository: CommonRepository
): GetAllEntityUseCase {
    override fun execute(): Flow<List<Cell>> {
        return repository.getAllEntity()
    }
}