package com.example.fetchcode.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(private val sharedPreferences: SharedPreferences) {
    companion object {
        const val COUNTER_KEY: String = "counter_key"
    }

    fun saveInt(key: String, data: Int) {
        sharedPreferences.edit().putInt(key, data).apply()
    }

    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

}