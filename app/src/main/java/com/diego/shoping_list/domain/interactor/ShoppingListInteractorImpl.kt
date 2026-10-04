package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.data.database.mapper.toDomain
import com.diego.shoping_list.data.database.mapper.toEntity
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

    override suspend fun changeListIcon(listId: Long, icon: ListIcon) {
        repository.updateListIcon(listId, icon.key)
    }

    override suspend fun copyList(list: ShoppingList): Result<Long> {
        return repository.copyList(list.id)
    }

    override suspend fun renameList(list: ShoppingList, name: String): Result<Unit> {
        val normalizedName = name.trim().lowercase()
        if (normalizedName.isEmpty()) {
            return Result.failure(IllegalArgumentException("Название не может быть пустым"))
        }

        val renamedList = list.copy(nameList = normalizedName)
        return repository.updateList(renamedList.toEntity())
    }

    override suspend fun deleteList(list: ShoppingList) {
        repository.deleteList(list.toEntity())
    }

    override suspend fun deleteAllLists() {
        repository.deleteAllLists()
    }
}
