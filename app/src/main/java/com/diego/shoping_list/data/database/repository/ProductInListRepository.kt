package com.diego.shoping_list.data.database.repository

import com.diego.shoping_list.data.database.entities.ProductInListEntity
import com.diego.shoping_list.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductInListRepository {

    fun observeByList(listId: Long): Flow<List<Product>>
    fun observeAllProduct(): Flow<List<Product>>

    suspend fun addProduct(
        listId: Long = 0,
        name: String,
        quantity: Int,
        unit: String
    ): Result<Long>

    suspend fun updateProduct(product: ProductInListEntity): Result<Unit>

    suspend fun deleteProduct(product: Product): Result<Unit>

    suspend fun deleteAllInList(listId: Long): Result<Unit>

    suspend fun deleteCheckedInList(listId: Long): Result<Unit>
}