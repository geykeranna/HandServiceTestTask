package ru.testtask.handservice.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.models.CellState
import ru.testtask.handservice.domain.repository.CommonRepository
import kotlin.random.Random

class CreateEntityUseCaseImpl(
    private val repository: CommonRepository
): CreateEntityUseCase {
    private val COUNT_LAST_LIST_SIZE = 3

    private fun createCell(): CellState {
        return if (Random.nextBoolean()) CellState.ALIVE_CELL else CellState.DEATH_CELL
    }

    private fun findLife(list: List<Cell>): Long? {
        val cell = list.findLast { item -> item.state == CellState.LIFE }
        return cell?.id
    }

    private suspend fun handleList(list: List<Cell>): Cell? {
        var newCellState: CellState?
        val lastList = list.takeLast(COUNT_LAST_LIST_SIZE)

        val isAllAlive = lastList.all { item -> item.state == CellState.ALIVE_CELL }
        val isAllDeath = lastList.all { item -> item.state == CellState.DEATH_CELL }

        when {
            isAllAlive && lastList.size >= COUNT_LAST_LIST_SIZE -> {
                newCellState = CellState.LIFE
            }
            isAllDeath && lastList.size >= COUNT_LAST_LIST_SIZE -> {
                val cellId = findLife(list)
                if(cellId != null) {
                    repository.deleteEntity(cellId)
                    newCellState = null
                } else {
                    newCellState = createCell()
                }
            }
            else -> {
                newCellState = createCell()
            }
        }
        return newCellState?.let { item -> Cell(state = item) }
    }


    override suspend fun execute(exist: List<Cell>): Flow<Boolean> {
        val result = handleList(exist)
        return when {
            result != null -> {
                repository.postEntity(cell = result)
            }
            else -> flowOf(true)
        }
    }
}