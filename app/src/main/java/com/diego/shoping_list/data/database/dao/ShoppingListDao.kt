package com.diego.shoping_list.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diego.shoping_list.data.database.entities.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {

    @Query("SELECT * FROM shopping_list_table")
    fun observeAll(): Flow<List<ShoppingListEntity>>

    @Query("""
        SELECT * FROM shopping_list_table
        WHERE nameList LIKE '%' || :query || '%'
        ORDER BY nameList
    """)
    fun searchByName(query: String): Flow<List<ShoppingListEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM shopping_list_table WHERE nameList = :name)")
    suspend fun existsByName(name: String): Boolean

    @Insert
    suspend fun insert(list: ShoppingListEntity): Long

    @Update
    suspend fun update(list: ShoppingListEntity)

    @Delete
    suspend fun delete(list: ShoppingListEntity)
}