package com.diego.shoping_list.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diego.shoping_list.data.database.entities.ProductNameEntity

@Dao
interface ProductNameDao {
    // Подсказки по префиксу, сортировка: сначала часто используемые, потом недавние
    @Query("""
        SELECT * FROM product_names_table
        WHERE name LIKE :prefix || '%'
        ORDER BY useCount DESC, lastUsed DESC
        LIMIT 10
    """)
    suspend fun suggestByName(prefix: String): List<ProductNameEntity>

    @Query("SELECT * FROM product_names_table WHERE name = :name LIMIT 1")
    suspend fun findByName(name: String): ProductNameEntity?

    @Insert
    suspend fun insert(name: ProductNameEntity): Long

    @Update
    suspend fun update(name: ProductNameEntity)
}