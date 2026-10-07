package com.diego.shoping_list.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
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

    @Query("SELECT * FROM shopping_list_table WHERE id = :id")
    suspend fun getById(id: Long): ShoppingListEntity?

    @Query("""
        INSERT INTO product_in_list_table (listId, name, quantity, unit, isChecked)
        SELECT :targetListId, name, quantity, unit, isChecked
        FROM product_in_list_table WHERE listId = :sourceListId
    """)
    suspend fun copyProducts(sourceListId: Long, targetListId: Long)

    @Transaction
    suspend fun copyList(id: Long): Long {
        val source = requireNotNull(getById(id)) { "Список не найден" }
        var copyName = "${source.nameList} (копия)"
        while (existsByName(copyName)) {
            copyName += " (копия)"
        }
        val copyId = insert(source.copy(id = 0, nameList = copyName))
        copyProducts(sourceListId = id, targetListId = copyId)
        return copyId
    }

    @Update
    suspend fun update(list: ShoppingListEntity)

    @Query("UPDATE shopping_list_table SET iconKey = :iconKey WHERE id = :id")
    suspend fun updateIcon(id: Long, iconKey: String)
    @Delete
    suspend fun delete(list: ShoppingListEntity)

    @Query("DELETE FROM shopping_list_table")
    suspend fun deleteAll()
}
