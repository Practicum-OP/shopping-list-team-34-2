package com.diego.shoping_list.di

import com.diego.shoping_list.domain.interactor.ShoppingListInteractor
import com.diego.shoping_list.domain.interactor.ShoppingListInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<ShoppingListInteractor> { ShoppingListInteractorImpl(get()) }
}
