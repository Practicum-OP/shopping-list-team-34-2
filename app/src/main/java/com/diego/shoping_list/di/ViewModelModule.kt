package com.diego.shoping_list.di

import com.diego.shoping_list.presentation.start.StartScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StartScreenViewModel(get()) }
}