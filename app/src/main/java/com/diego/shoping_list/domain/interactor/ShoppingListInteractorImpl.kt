package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.data.database.mapper.toDomain
import com.diego.shoping_list.data.database.repository.ShoppingListRepository
import com.diego.shoping_list.domain.ListIcon
import com.diego.shoping_list.domain.ShoppingList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ShoppingListInteractorImpl(
    private val repository: ShoppingListRepository
) : ShoppingListInteractor {

    override fun getLists(): Flow<List<ShoppingList>> {
        return repository.searchByName("").map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addList(name: String) {
        repository.addList(name, ListIcon.default.key)
    }
}
