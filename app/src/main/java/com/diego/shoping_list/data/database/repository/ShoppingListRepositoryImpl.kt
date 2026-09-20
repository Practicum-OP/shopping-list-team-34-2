package com.diego.shoping_list.data.database.repository

import com.diego.shoping_list.data.database.dao.ShoppingListDao
import com.diego.shoping_list.data.database.entities.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

class ShoppingListRepositoryImpl(
    private val dao: ShoppingListDao
) : ShoppingListRepository {
    override fun searchByName(query: String): Flow<List<ShoppingListEntity>> {
        return if (query.isBlank()){
            dao.observeAll()
        } else {
            dao.searchByName(query)
        }
    }

    override suspend fun addList(name: String, iconKey: String): Result<Long> {
        val trimmed = name.trim()
        val lower = trimmed.lowercase()

        if (trimmed.isEmpty()) {
            return Result.failure(IllegalArgumentException("Название не может быть пустым"))
        }

        if (dao.existsByName(lower)) {
            return Result.failure(IllegalStateException("Список с таким именем уже есть"))
        }

        return try {
            val id = dao.insert(
                ShoppingListEntity(nameList = lower, iconKey = iconKey)
            )
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateList(list: ShoppingListEntity): Result<Unit> {
        return try {
            dao.update(list)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteList(list: ShoppingListEntity): Result<Unit> {
        return try {
            dao.delete(list)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}