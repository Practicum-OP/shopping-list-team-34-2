package com.diego.shoping_list.data.database.repository

import com.diego.shoping_list.data.database.entities.ProductInListEntity
import kotlinx.coroutines.flow.Flow

interface ProductInListRepository {

    fun observeByList(listId: Long): Flow<List<ProductInListEntity>>
    fun observeAllProduct(): Flow<List<ProductInListEntity>>

    suspend fun addProduct(
        listId: Long,
        name: String,
        quantity: Int,
        unit: String
    ): Result<Long>

    suspend fun updateProduct(product: ProductInListEntity): Result<Unit>

    suspend fun deleteProduct(product: ProductInListEntity): Result<Unit>

    suspend fun deleteAllInList(listId: Long): Result<Unit>

    suspend fun deleteCheckedInList(listId: Long): Result<Unit>
}