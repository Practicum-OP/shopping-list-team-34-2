package com.diego.shoping_list.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diego.shoping_list.data.database.entities.ProductNameEntity
import com.diego.shoping_list.domain.model.ProductSuggestion
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductNameDao {
    // Подсказки по префиксу, сортировка: сначала часто используемые, потом недавние
    @Query("""
        SELECT * FROM product_names_table
        WHERE name LIKE :query || '%'
        ORDER BY useCount DESC, lastUsed DESC
        LIMIT :limit
    """)
    fun suggestByName(query: String, limit: Int = 10): Flow<List<ProductNameEntity>>

    @Query("SELECT * FROM product_names_table WHERE name = :name LIMIT 1")
    suspend fun findByName(name: String): ProductNameEntity?

    @Insert
    suspend fun insert(name: ProductNameEntity): Long

    @Update
    suspend fun update(name: ProductNameEntity)
}