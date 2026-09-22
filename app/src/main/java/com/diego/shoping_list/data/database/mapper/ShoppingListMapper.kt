package com.diego.shoping_list.data.database.mapper

import com.diego.shoping_list.data.database.entities.ShoppingListEntity
import com.diego.shoping_list.domain.ShoppingList

fun ShoppingListEntity.toDomain(): ShoppingList = ShoppingList(
    id = id,
    nameList = nameList.replaceFirstChar { it.uppercase() },
    iconKey = iconKey
)
