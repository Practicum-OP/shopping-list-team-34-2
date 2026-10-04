package com.diego.shoping_list.di

import androidx.room.Room
import com.diego.shoping_list.data.database.AppDatabase
import com.diego.shoping_list.data.database.AppDatabaseWarmer
import com.diego.shoping_list.data.network.api.ApiService
import com.google.gson.Gson
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val AUTH_BASE_URL = "https://faiwlkhyssrgofauzegs.supabase.co/functions/v1/"
val dataModule = module {
    single<Gson> { Gson() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(AUTH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

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