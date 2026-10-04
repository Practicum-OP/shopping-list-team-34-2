package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.domain.ListIcon
import com.diego.shoping_list.domain.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListInteractor {
    fun getLists(): Flow<List<ShoppingList>>

    suspend fun addList(name: String)

    suspend fun copyList(list: ShoppingList): Result<Long>

    suspend fun changeListIcon(listId: Long, icon: ListIcon)
    suspend fun renameList(list: ShoppingList, name: String): Result<Unit>
    suspend fun deleteList(list: ShoppingList)
    suspend fun deleteAllLists()
}
