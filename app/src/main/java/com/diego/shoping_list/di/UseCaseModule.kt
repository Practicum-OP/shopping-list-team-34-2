package com.diego.shoping_list.di

import com.diego.shoping_list.domain.use_cases.WarmUpDatabaseUseCase
import com.diego.shoping_list.domain.use_cases.WarmUpDatabaseUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<WarmUpDatabaseUseCase> { WarmUpDatabaseUseCaseImpl(get()) }
}