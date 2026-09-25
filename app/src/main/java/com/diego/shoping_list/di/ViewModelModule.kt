package com.diego.shoping_list.di

import com.diego.shoping_list.presentation.products.ProductsViewModel
import com.diego.shoping_list.presentation.shoppingList.view_model.ShoppingListViewModel
import com.diego.shoping_list.presentation.start.StartScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ProductsViewModel)
    viewModelOf(::ShoppingListViewModel)
    viewModelOf(::StartScreenViewModel)
}
