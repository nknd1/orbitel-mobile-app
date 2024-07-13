package com.example.myorbitel.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object TokenManager {
    var token: String? = null
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

object PreferencesKeys {
    val JWT_TOKEN = stringPreferencesKey("jwt_token")
}

suspend fun saveToken(
    context: Context,
    token: String,
) {
    context.dataStore.edit { preferences ->
        preferences[PreferencesKeys.JWT_TOKEN] = token
    }
}

suspend fun getToken(context: Context): String? {
    val preferences = context.dataStore.data.first()
    return preferences[PreferencesKeys.JWT_TOKEN]
}
