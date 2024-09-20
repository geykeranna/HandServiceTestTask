package ru.testtask.handservice

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.testtask.handservice.data.dataDi
import ru.testtask.handservice.domain.domainDi
import ru.testtask.handservice.ui.uiDi

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(listOf(domainDi, dataDi, uiDi))
        }
    }
}