package com.diego.shoping_list.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diego.shoping_list.data.database.dao.ProductInListDao
import com.diego.shoping_list.data.database.dao.ProductNameDao
import com.diego.shoping_list.data.database.dao.ShoppingListDao
import com.diego.shoping_list.data.database.entities.ProductInListEntity
import com.diego.shoping_list.data.database.entities.ProductNameEntity
import com.diego.shoping_list.data.database.entities.ShoppingListEntity

@Database(
    version = 1,
    entities = [
        ShoppingListEntity::class,
        ProductInListEntity::class,
        ProductNameEntity::class
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingListDao(): ShoppingListDao
    abstract fun productInListDao(): ProductInListDao
    abstract fun productNameDao(): ProductNameDao
}