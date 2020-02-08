package com.app.common.preference;

import android.content.Context;
import android.content.SharedPreferences;

class LocalPreferences(mContext: Context, name: String) {

    private val sharedPreference: SharedPreferences

    var token: String?
        get() = sharedPreference.getString(PrefKey.TOKEN, null)
        set(token) = sharedPreference.edit().putString(PrefKey.TOKEN, token).apply()

    var username: String?
        get() = sharedPreference.getString(PrefKey.USERNAME, null)
        set(username) = sharedPreference.edit().putString(PrefKey.USERNAME, username).apply()

    init {
        sharedPreference = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    companion object {
        private val TAG = "LocalPreferences"
    }

}

