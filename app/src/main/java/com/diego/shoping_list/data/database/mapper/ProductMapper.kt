package com.diego.shoping_list.data.database.mapper

import com.diego.shoping_list.data.database.entities.ProductInListEntity
import com.diego.shoping_list.domain.model.Product

object ProductMapper {
    fun productMapFromEntity(product: ProductInListEntity): Product {
        return Product(
            id = product.id,
            listId = product.listId,
            name = product.name,
            quantity = product.quantity,
            unit = product.unit,
            isChecked = product.isChecked,
            positionInList = product.positionInList
        )
    }

    fun productMapToEntity(product: Product): ProductInListEntity {
        return ProductInListEntity(
            id = product.id,
            listId = product.listId,
            name = product.name,
            quantity = product.quantity,
            unit = product.unit,
            isChecked = product.isChecked,
            positionInList = product.positionInList
        )
    }
}