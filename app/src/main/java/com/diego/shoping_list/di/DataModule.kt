package com.diego.shoping_list.di

import androidx.room.Room
import com.diego.shoping_list.data.database.AppDatabase
import com.diego.shoping_list.data.database.AppDatabaseWarmer
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = "database.db"
        ).build()
    }

    single { get<AppDatabase>().shoppingListDao() }
    single { get<AppDatabase>().productInListDao() }
    single { get<AppDatabase>().productNameDao() }

    single { AppDatabaseWarmer(get()) }
}