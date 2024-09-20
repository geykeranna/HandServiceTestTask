package ru.testtask.handservice.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import ru.testtask.handservice.data.database.dao.CellDao
import ru.testtask.handservice.data.database.models.CellEntity
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.domain.models.CellState
import ru.testtask.handservice.domain.repository.CommonRepository

class CommonRepositoryImpl(
    private val dao: CellDao,
) : CommonRepository {
    override fun getAllEntity(): Flow<List<Cell>> {
        return dao.getAll().map { flow ->
            flow.map { cell ->
                Cell(
                    id = cell.id,
                    state = CellState.getValue(cell.state)
                )
            }
        }
    }

    override fun getOneEntity(id: Long): Flow<Cell> {
        return dao.getOne(id = id).map { flow ->
            Cell(
                id = flow.id,
                state = CellState.getValue(flow.state)
            )
        }
    }

    override suspend fun postEntity(cell: Cell): Flow<Boolean> {
        val newValue = CellEntity(
            id = cell.id,
            state = cell.state.name,
        )
        return try {
            dao.insertCell(cell = newValue)
            flowOf(true)
        } catch (e: Error){
            flowOf(false)
        }
    }

    override suspend fun deleteEntity(id: Long): Flow<Boolean> {
        return try {
            dao.delete(id = id)
            flowOf(true)
        } catch (e: Error){
            flowOf(false)
        }
    }
}