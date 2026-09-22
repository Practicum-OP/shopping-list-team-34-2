
import com.diego.shoping_list.presentation.products.ProductsViewModel
package com.diego.shoping_list.di

import com.diego.shoping_list.presentation.shoppingList.view_model.ShoppingListViewModel
import com.diego.shoping_list.presentation.start.StartScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductsViewModel() }
}
    viewModel {
        ShoppingListViewModel(get())
    }
    
    viewModel { 
      StartScreenViewModel(get()) 
    }
}
