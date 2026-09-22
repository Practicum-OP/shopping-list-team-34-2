package com.diego.shoping_list.data.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppDatabaseWarmer(
    private val database: AppDatabase
) {
    /**
     * Открывает файл БД, применяет миграции, создаёт таблицы.
     * Безопасно вызывать несколько раз — Room держит открытое соединение.
     */

    suspend fun warmUp() = withContext(Dispatchers.IO) {
        // writableDatabase инициализирует SQLite и выполняет onCreate/onUpgrade
//        database.openHelper.writableDatabase

        val start = System.currentTimeMillis()
        database.openHelper.writableDatabase
        val elapsed = System.currentTimeMillis() - start
        android.util.Log.d("DB_WARMUP", "БД открыта за $elapsed мс")
    }
}