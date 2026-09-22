package com.diego.shoping_list.di

import com.diego.shoping_list.presentation.shoppingList.view_model.ShoppingListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ShoppingListViewModel(get())
    }
}
