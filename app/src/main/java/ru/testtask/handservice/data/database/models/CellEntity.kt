package ru.testtask.handservice.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.testtask.handservice.data.database.utils.Constrains.TABLE_DATABASE

@Entity(tableName = TABLE_DATABASE)
data class CellEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val state: String,
)