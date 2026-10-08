package com.diego.shoping_list.di

import com.diego.shoping_list.data.database.repository.ProductInListRepositoryImpl
import com.diego.shoping_list.data.database.repository.ShoppingListRepository
import com.diego.shoping_list.data.database.repository.ShoppingListRepositoryImpl
import com.diego.shoping_list.domain.repository.AuthRepository
import com.diego.shoping_list.data.network.AuthRepositoryImpl
import com.diego.shoping_list.data.network.SessionRepositoryImpl
import com.diego.shoping_list.domain.repository.SessionRepository
import com.diego.shoping_list.data.settings.SortModeRepository
import com.diego.shoping_list.domain.api.ProductInListRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<ShoppingListRepository> {
        ShoppingListRepositoryImpl(get(), get())
    }
    single<ProductInListRepository> {
        ProductInListRepositoryImpl(get(), get())
    }

    single {
        SortModeRepository(androidContext())
    }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<SessionRepository> { SessionRepositoryImpl() }
}