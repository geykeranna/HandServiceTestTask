package ru.testtask.handservice.data.database.utils

import android.content.Context
import androidx.room.Room
import ru.testtask.handservice.data.database.Database
import ru.testtask.handservice.data.database.utils.Constrains.DATABASE

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context = context, Database::class.java, DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: Database) = db.getDao()