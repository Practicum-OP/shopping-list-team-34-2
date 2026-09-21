package com.diego.shoping_list.data.database.repository

import com.diego.shoping_list.data.database.entities.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {
    fun searchByName(query: String): Flow<List<ShoppingListEntity>>

    suspend fun addList(name: String, iconKey: String): Result<Long>

    suspend fun updateList(list: ShoppingListEntity): Result<Unit>

    suspend fun deleteList(list: ShoppingListEntity): Result<Unit>
}