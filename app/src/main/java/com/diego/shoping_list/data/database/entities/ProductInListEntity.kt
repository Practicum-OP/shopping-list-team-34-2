package com.diego.shoping_list.data.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "product_in_list_table",
    indices = [
        Index(value = ["listId"]),
        Index(value = ["name"])
    ]
)
data class ProductInListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val listId: Long,
    val name: String,
    val quantity: Int,
    val unit: String = "",
    val isChecked: Boolean = false
)
