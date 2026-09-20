package com.diego.shoping_list.data.database.repository

import com.diego.shoping_list.data.database.dao.ProductInListDao
import com.diego.shoping_list.data.database.dao.ProductNameDao
import com.diego.shoping_list.data.database.entities.ProductInListEntity
import com.diego.shoping_list.data.database.entities.ProductNameEntity
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.cancellation.CancellationException

class ProductInListRepositoryImpl(
    private val productDao: ProductInListDao,
    private val productNameDao: ProductNameDao     // для автосохранения в справочник
) : ProductInListRepository {

    override fun observeByList(listId: Long): Flow<List<ProductInListEntity>> =
        productDao.observeByList(listId)

    override fun observeAllProduct(): Flow<List<ProductInListEntity>> {
        return productDao.observeAllProducts()
    }

    override suspend fun addProduct(
        listId: Long,
        name: String,
        quantity: Int,
        unit: String
    ): Result<Long> {
        val trimmed = name.trim()

        if (trimmed.isEmpty()) {
            return Result.failure(IllegalArgumentException("Название продукта не может быть пустым"))
        }

        if (quantity <= 0) {
            return Result.failure(IllegalArgumentException("Количество должно быть больше нуля"))
        }

        return try {
            val id = productDao.insert(
                ProductInListEntity(
                    listId = listId,
                    name = trimmed,
                    quantity = quantity,
                    unit = unit
                )
            )

            // Автосохранение в справочник для автодополнения в будущем
            saveToCatalog(trimmed, unit)

            Result.success(id)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateProduct(product: ProductInListEntity): Result<Unit> {
        return try {
            productDao.update(product)
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteProduct(product: ProductInListEntity): Result<Unit> {
        return try {
            productDao.delete(product)
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteAllInList(listId: Long): Result<Unit> {
        return try {
            productDao.deleteByList(listId)
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteCheckedInList(listId: Long): Result<Unit> {
        return try {
            productDao.deleteChecked(listId)
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // сохранить/обновить имя в справочнике
    private suspend fun saveToCatalog(name: String, unit: String) {
        val existing = productNameDao.findByName(name)

        if (existing == null) {
            productNameDao.insert(
                ProductNameEntity(
                    name = name,
                    defaultUnit = unit,
                    useCount = 1,
                    lastUsed = System.currentTimeMillis()
                )
            )
        } else {
            productNameDao.update(
                existing.copy(
                    useCount = existing.useCount + 1,
                    lastUsed = System.currentTimeMillis(),
                    defaultUnit = unit
                )
            )
        }
    }
}