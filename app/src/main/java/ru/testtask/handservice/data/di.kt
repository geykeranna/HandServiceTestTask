package ru.testtask.handservice.data

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.testtask.handservice.data.database.utils.provideDao
import ru.testtask.handservice.data.database.utils.provideDatabase
import ru.testtask.handservice.data.repository.CommonRepositoryImpl
import ru.testtask.handservice.domain.repository.CommonRepository

val dataDi = module {
    single { provideDatabase(androidContext()) }

    single { provideDao(get()) }

    singleOf(::CommonRepositoryImpl) { bind<CommonRepository>() }
}