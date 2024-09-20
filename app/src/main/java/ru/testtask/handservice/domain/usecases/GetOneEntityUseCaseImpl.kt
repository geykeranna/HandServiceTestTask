package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.repository.CommonRepository

class GetOneEntityUseCaseImpl(
    private val repository: CommonRepository
): GetOneEntityUseCase {
    override fun execute(id: Long): Flow<Cell> {
        return repository.getOneEntity(id = id)
    }
}