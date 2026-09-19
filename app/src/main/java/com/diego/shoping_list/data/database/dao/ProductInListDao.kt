package com.diego.shoping_list.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diego.shoping_list.data.database.entities.ProductInListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductInListDao {
    @Query("""
        SELECT * FROM product_in_list_table 
        WHERE listId = :listId 
        ORDER BY isChecked, name
    """)
    fun observeByList(listId: Long): Flow<List<ProductInListEntity>>

    @Insert
    suspend fun insert(product: ProductInListEntity): Long

    @Update
    suspend fun update(product: ProductInListEntity)

    @Delete
    suspend fun delete(product: ProductInListEntity)

    @Query("DELETE FROM product_in_list_table WHERE listId = :listId")
    suspend fun deleteByList(listId: Long)

    @Query("DELETE FROM product_in_list_table WHERE isChecked = 1 AND listId = :listId")
    suspend fun deleteChecked(listId: Long)
}