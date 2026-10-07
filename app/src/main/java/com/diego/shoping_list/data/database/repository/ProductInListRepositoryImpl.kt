package com.diego.shoping_list.data.database.repository

import android.util.Log
import com.diego.shoping_list.data.database.dao.ProductInListDao
import com.diego.shoping_list.data.database.dao.ProductNameDao
import com.diego.shoping_list.data.database.entities.ProductInListEntity
import com.diego.shoping_list.data.database.entities.ProductNameEntity
import com.diego.shoping_list.data.database.mapper.ProductMapper
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.api.ProductInListRepository
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Locale
import kotlin.coroutines.cancellation.CancellationException

class ProductInListRepositoryImpl(
    private val productDao: ProductInListDao,
    private val productNameDao: ProductNameDao     // для автосохранения в справочник
) : ProductInListRepository {

    private val mapper = ProductMapper

    override fun observeByList(listId: Long, sortMode: SortMode): Flow<List<Product>> {
        val source = when (sortMode) {
            SortMode.ALPHABETICAL -> productDao.observeByListAlphabetical(listId)
            SortMode.MANUAL -> productDao.observeByListManual(listId)
        }
        return source.map { entities -> entities.map(mapper::productMapFromEntity) }

    }

    override fun observeAllProduct(): Flow<List<Product>> =
        productDao.observeAllProducts().map { entities ->
            entities.map(mapper::productMapFromEntity)
        }

    override fun observeSuggestions(query: String): Flow<List<ProductSuggestion>> =
        productNameDao.suggestByName(query)
            .map { list ->
                list.map { entity ->
                    ProductSuggestion(
                        name = entity.name
                            .replaceFirstChar { it.titlecase(Locale.getDefault()) },
                        defaultUnit = entity.defaultUnit
                    )
                }
            }

    override suspend fun addProduct(
        listId: Long,
        name: String,
        quantity: Int,
        unit: String
    ): Result<Long> {
        val position = productDao.nextPosition(listId)

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
                    unit = unit,
                    positionInList = position
                )
            )
            Log.d("ProductList", "$id, $trimmed, $unit")
            // Автосохранение в справочник для автодополнения в будущем
            saveToCatalog(trimmed, unit)

            Result.success(id)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateProduct(product: Product): Result<Unit> {
        return try {
            productDao.update(mapper.productMapToEntity(product))
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateChecked(productId: Long, checked: Boolean): Result<Unit> {
        return try {
            productDao.updateChecked(productId, checked)
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteProduct(product: Product): Result<Unit> {
        return try {
            productDao.delete(mapper.productMapToEntity(product))
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

    override suspend fun saveOrder(listId: Long, orderedIds: List<Long>): Result<Unit> {
        return try {
            productDao.saveOrder(listId, orderedIds)
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
                    name = name.lowercase(),
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