package com.diego.shoping_list.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.diego.shoping_list.data.database.entities.ProductInListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductInListDao {
    @Query(
        """
        SELECT * FROM product_in_list_table 
        WHERE listId = :listId 
        ORDER BY isChecked, name, id
    """
    )
    fun observeByListAlphabetical(listId: Long): Flow<List<ProductInListEntity>>

    @Query(
        """
        SELECT * FROM product_in_list_table
        WHERE listId = :listId
        ORDER BY positionInList, id
    """
    )
    fun observeByListManual(listId: Long): Flow<List<ProductInListEntity>>

    @Query("SELECT * FROM product_in_list_table")
    fun observeAllProducts(): Flow<List<ProductInListEntity>>

    @Query("SELECT COALESCE(MAX(positionInList), 0) + 1 FROM product_in_list_table WHERE listId = :listId")
    suspend fun nextPosition(listId: Long): Int

    @Query("SELECT * FROM product_in_list_table WHERE listId = :listId")
    suspend fun getByList(listId: Long): List<ProductInListEntity>

    @Insert
    suspend fun insert(product: ProductInListEntity): Long

    @Update
    suspend fun update(product: ProductInListEntity)

    @Update
    suspend fun updateAll(products: List<ProductInListEntity>)

    @Query("UPDATE product_in_list_table SET isChecked = :checked WHERE id = :productId")
    suspend fun updateChecked(productId: Long, checked: Boolean)

    @Delete
    suspend fun delete(product: ProductInListEntity)

    @Query("DELETE FROM product_in_list_table WHERE listId = :listId")
    suspend fun deleteByList(listId: Long)

    @Query("DELETE FROM product_in_list_table WHERE isChecked = 1 AND listId = :listId")
    suspend fun deleteChecked(listId: Long)

    @Query("DELETE FROM product_in_list_table")
    suspend fun deleteAll()

    @Transaction
    suspend fun saveOrder(listId: Long, orderedIds: List<Long>) {
        val byId = getByList(listId).associateBy { it.id }
        val updated = orderedIds.mapIndexedNotNull { index, id ->
            byId[id]?.copy(positionInList = index)
        }
        updateAll(updated)
    }
}