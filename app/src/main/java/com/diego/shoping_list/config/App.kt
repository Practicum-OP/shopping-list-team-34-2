package com.diego.shoping_list.config

import android.app.Application
import com.diego.shoping_list.di.dataModule
import com.diego.shoping_list.di.interactorModule
import com.diego.shoping_list.di.repositoryModule
import com.diego.shoping_list.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                repositoryModule,
                interactorModule,
                viewModelModule
            )
        }
    }
}