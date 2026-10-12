package com.diego.shoping_list.presentation.common

import android.util.Log

object AppLogger {
    private const val TAG = "ShoppingList"
    fun e(throwable: Throwable, message: String) {
        Log.e(TAG, message, throwable)
    }
}