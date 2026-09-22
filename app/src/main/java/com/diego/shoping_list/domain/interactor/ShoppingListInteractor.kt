package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.domain.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListInteractor {
    fun getLists(): Flow<List<ShoppingList>>

    suspend fun addList(name: String)
}
