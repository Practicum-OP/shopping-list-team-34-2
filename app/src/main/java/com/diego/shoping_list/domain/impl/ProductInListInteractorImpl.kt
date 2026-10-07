package com.diego.shoping_list.domain.impl

import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.api.ProductInListInteractor
import com.diego.shoping_list.domain.api.ProductInListRepository
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import kotlinx.coroutines.flow.Flow

class ProductInListInteractorImpl(private val productInListRepository: ProductInListRepository) :
    ProductInListInteractor {
    override fun observeByList(listId: Long, sortMode: SortMode): Flow<List<Product>> {
        return productInListRepository.observeByList(listId, sortMode)
    }

    override fun observeAllProduct(): Flow<List<Product>> {
        return productInListRepository.observeAllProduct()
    }

    override fun observeSuggestions(query: String): Flow<List<ProductSuggestion>> {
        return productInListRepository.observeSuggestions(query)
    }

    override suspend fun addProduct(
        listId: Long,
        name: String,
        quantity: Int,
        unit: String
    ): Result<Long> {
        return productInListRepository.addProduct(
            listId = listId,
            name = name,
            quantity = quantity,
            unit = unit
        )
    }


    override suspend fun updateProduct(product: Product): Result<Unit> {
        return productInListRepository.updateProduct(product)
    }

    override suspend fun updateChecked(
        productId: Long,
        checked: Boolean
    ): Result<Unit> {
        return productInListRepository.updateChecked(
            productId = productId,
            checked = checked
        )
    }

    override suspend fun deleteProduct(product: Product): Result<Unit> {
        return productInListRepository.deleteProduct(product)
    }

    override suspend fun deleteAllInList(listId: Long): Result<Unit> {
        return productInListRepository.deleteAllInList(listId)
    }

    override suspend fun deleteCheckedInList(listId: Long): Result<Unit> {
        return productInListRepository.deleteCheckedInList(listId)
    }

    override suspend fun saveOrder(listId: Long, orderedIds: List<Long>): Result<Unit> =
        productInListRepository.saveOrder(listId, orderedIds)

}