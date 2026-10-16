package com.diego.shoping_list.data.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.diego.shoping_list.domain.ListIcon

@Entity(
    tableName = "shopping_list_table",
    indices = [Index(value = ["nameList"], unique = true)]
)
data class ShoppingListEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nameList: String,
    val iconKey: String = ListIcon.default.key
)
