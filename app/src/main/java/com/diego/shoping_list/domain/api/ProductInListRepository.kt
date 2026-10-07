package com.diego.shoping_list.domain.api

import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import kotlinx.coroutines.flow.Flow

interface ProductInListRepository {

    fun observeByList(listId: Long, sortMode: SortMode): Flow<List<Product>>
    fun observeAllProduct(): Flow<List<Product>>

    fun observeSuggestions(query: String): Flow<List<ProductSuggestion>>

    suspend fun addProduct(
        listId: Long,
        name: String,
        quantity: Int,
        unit: String
    ): Result<Long>

    suspend fun updateProduct(product: Product): Result<Unit>

    suspend fun updateChecked(productId: Long, checked: Boolean): Result<Unit>

    suspend fun deleteProduct(product: Product): Result<Unit>

    suspend fun deleteAllInList(listId: Long): Result<Unit>

    suspend fun deleteCheckedInList(listId: Long): Result<Unit>

    suspend fun saveOrder(listId: Long, orderedIds: List<Long>): Result<Unit>
}