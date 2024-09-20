package ru.testtask.handservice.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.testtask.handservice.data.database.models.CellEntity
import ru.testtask.handservice.data.database.utils.Constrains.DATABASE
import ru.testtask.handservice.data.database.utils.Constrains.TABLE_DATABASE

@Dao
interface CellDao {
    @Upsert
    suspend fun insertCell(cell: CellEntity)

    @Query("DELETE FROM $TABLE_DATABASE WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT * FROM $TABLE_DATABASE")
    fun getAll(): Flow<List<CellEntity>>

    @Query("SELECT * FROM $TABLE_DATABASE WHERE id = :id")
    fun getOne(id: Long): Flow<CellEntity>
}