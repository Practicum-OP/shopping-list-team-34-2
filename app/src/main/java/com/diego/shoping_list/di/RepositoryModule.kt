package com.diego.shoping_list.di

import com.diego.shoping_list.data.database.repository.ProductInListRepository
import com.diego.shoping_list.data.database.repository.ProductInListRepositoryImpl
import com.diego.shoping_list.data.database.repository.ShoppingListRepository
import com.diego.shoping_list.data.database.repository.ShoppingListRepositoryImpl
import com.diego.shoping_list.domain.repository.AuthRepository
import com.diego.shoping_list.data.network.AuthRepositoryImpl
import com.diego.shoping_list.data.network.SessionRepositoryImpl
import com.diego.shoping_list.domain.repository.SessionRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ShoppingListRepository> {
        ShoppingListRepositoryImpl(get(), get())
    }
    single<ProductInListRepository> {
        ProductInListRepositoryImpl(get(), get(), get())
    }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<SessionRepository> { SessionRepositoryImpl() }
}