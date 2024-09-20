package ru.testtask.handservice.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.testtask.handservice.data.database.dao.CellDao
import ru.testtask.handservice.data.database.models.CellEntity
import ru.testtask.handservice.domain.models.Cell

@Database(entities = [CellEntity::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun getDao(): CellDao
}