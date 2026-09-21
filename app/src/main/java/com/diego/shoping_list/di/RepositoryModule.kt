package com.diego.shoping_list.di

import com.diego.shoping_list.data.database.repository.ProductInListRepository
import com.diego.shoping_list.data.database.repository.ProductInListRepositoryImpl
import com.diego.shoping_list.data.database.repository.ShoppingListRepository
import com.diego.shoping_list.data.database.repository.ShoppingListRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ShoppingListRepository> {
        ShoppingListRepositoryImpl(get(), get())
    }
    single<ProductInListRepository> {
        ProductInListRepositoryImpl(get(), get())
    }
}