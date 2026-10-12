package com.diego.shoping_list.domain.use_cases

import com.diego.shoping_list.data.database.AppDatabaseWarmer

class WarmUpDatabaseUseCaseImpl(private val dbWarmer: AppDatabaseWarmer) : WarmUpDatabaseUseCase {
    override suspend operator fun invoke() {
        dbWarmer.warmUp()
    }
}

interface WarmUpDatabaseUseCase {
    suspend operator fun invoke()
}