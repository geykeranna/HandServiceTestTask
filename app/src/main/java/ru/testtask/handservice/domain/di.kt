package ru.testtask.handservice.domain

import org.koin.dsl.module
import ru.testtask.handservice.domain.usecases.CreateEntityUseCase
import ru.testtask.handservice.domain.usecases.CreateEntityUseCaseImpl
import ru.testtask.handservice.domain.usecases.DeleteEntityUseCase
import ru.testtask.handservice.domain.usecases.DeleteEntityUseCaseImpl
import ru.testtask.handservice.domain.usecases.GetAllEntityUseCase
import ru.testtask.handservice.domain.usecases.GetAllEntityUseCaseImpl
import ru.testtask.handservice.domain.usecases.GetOneEntityUseCase
import ru.testtask.handservice.domain.usecases.GetOneEntityUseCaseImpl

val domainDi = module {
    single<GetAllEntityUseCase> { GetAllEntityUseCaseImpl(get()) }
    single<GetOneEntityUseCase> { GetOneEntityUseCaseImpl(get()) }
    single<CreateEntityUseCase> { CreateEntityUseCaseImpl(get()) }
    single<DeleteEntityUseCase> { DeleteEntityUseCaseImpl(get()) }
}