package ru.testtask.handservice.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.domain.models.Cell

interface CommonRepository {
    fun getAllEntity(): Flow<List<Cell>>

    fun getOneEntity(id: Long): Flow<Cell>

    suspend fun postEntity(cell: Cell): Flow<Boolean>

    suspend fun deleteEntity(cell: Cell): Flow<Boolean>
}