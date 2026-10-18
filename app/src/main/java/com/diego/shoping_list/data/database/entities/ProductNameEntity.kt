package com.diego.shoping_list.data.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "product_names_table",
    indices = [Index(value = ["name"], unique = true)]
)
data class ProductNameEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val defaultUnit: String,
    val useCount: Int = 1,
    val lastUsed: Long = System.currentTimeMillis()
)
