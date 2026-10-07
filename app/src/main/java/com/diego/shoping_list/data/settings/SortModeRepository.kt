package com.diego.shoping_list.data.settings

import android.content.Context
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.diego.shoping_list.domain.SortMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class SortModeRepository(private val context: Context) {

    private fun keyFor(listId: Long) = stringPreferencesKey("sort_mode_$listId")

    fun sortMode(listId: Long): Flow<SortMode> = context.sortModeDataStore.data
        .catch { e ->
            if (e is IOException) emit(emptyPreferences()) else throw e
        }
        .map { prefs ->
            val name = prefs[keyFor(listId)] ?: SortMode.ALPHABETICAL.name
            runCatching { SortMode.valueOf(name) }
                .getOrDefault(SortMode.ALPHABETICAL)
        }

    suspend fun save(listId: Long, mode: SortMode) {
        context.sortModeDataStore.edit { prefs ->
            prefs[keyFor(listId)] = mode.name
        }
    }

    suspend fun clear(listId: Long) {
        context.sortModeDataStore.edit { prefs ->
            prefs.remove(keyFor(listId))
        }
    }
}