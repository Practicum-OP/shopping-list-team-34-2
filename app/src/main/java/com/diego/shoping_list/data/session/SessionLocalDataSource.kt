package com.diego.shoping_list.data.session

import android.content.Context
import android.content.SharedPreferences

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
        preferences.edit()
            .putString(KEY_ACCESS_TOKEN, accessToken)
            .putString(KEY_REFRESH_TOKEN, refreshToken)
            .putLong(KEY_USER_ID, userId)
            .apply()
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
        preferences.edit()
            .remove(KEY_ACCESS_TOKEN)
            .remove(KEY_REFRESH_TOKEN)
            .remove(KEY_USER_ID)
            .apply()
    }

    private companion object {
        const val KEY_ACCESS_TOKEN = "access_token"
        const val KEY_REFRESH_TOKEN = "refresh_token"
        const val KEY_USER_ID = "user_id"
    }
}