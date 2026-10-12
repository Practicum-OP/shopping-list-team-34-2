package com.diego.shoping_list.data.session

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SessionLocalDataSource(
    context: Context
) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            "session_preferences",
            Context.MODE_PRIVATE
        )

    fun saveSession(
        accessToken: String,
        refreshToken: String,
        userId: Long
    ) {
        preferences.edit {
            putString(KEY_ACCESS_TOKEN, accessToken)
                .putString(KEY_REFRESH_TOKEN, refreshToken)
                .putLong(KEY_USER_ID, userId)
        }
    }

    fun getAccessToken(): String? {
        return preferences.getString(KEY_ACCESS_TOKEN, null)
    }

    fun getRefreshToken(): String? {
        return preferences.getString(KEY_REFRESH_TOKEN, null)
    }

    fun getUserId(): Long {
        return preferences.getLong(KEY_USER_ID, -1L)
    }

    fun clearSession() {
        preferences.edit {
            remove(KEY_ACCESS_TOKEN)
                .remove(KEY_REFRESH_TOKEN)
                .remove(KEY_USER_ID)
                .remove(KEY_REMEMBER_ME)
        }
    }

    fun saveRememberMe(remember: Boolean) {
        preferences.edit {
            putBoolean(KEY_REMEMBER_ME, remember)
        }
    }

    fun shouldRememberMe(): Boolean {
        return preferences.getBoolean(KEY_REMEMBER_ME, false)
    }

    private companion object {
        const val KEY_ACCESS_TOKEN = "access_token"
        const val KEY_REFRESH_TOKEN = "refresh_token"
        const val KEY_USER_ID = "user_id"
        const val KEY_REMEMBER_ME = "remember_me"
    }
}