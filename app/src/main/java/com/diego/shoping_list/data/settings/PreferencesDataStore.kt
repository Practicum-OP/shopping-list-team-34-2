package com.diego.shoping_list.data.settings

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.sortModeDataStore by preferencesDataStore(name = "sort_mode_prefs")