package com.miko.app.utils

import android.util.Log

object Logger {

    private const val TAG = "MIKO"

    fun d(message: String) {

        Log.d(TAG, message)

    }

    fun e(message: String) {

        Log.e(TAG, message)

    }

}
