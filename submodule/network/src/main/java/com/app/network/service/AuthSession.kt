package com.app.network.service;


import com.app.common.preference.LocalPreferences;


class AuthSession(private val localPreferences: LocalPreferences) : AuthProvider {
    override val token: String
        get() = if (localPreferences.token == null) "" else localPreferences.token!!

    override val userId: String
        get() = if (localPreferences.username == null) "" else localPreferences.username!!

}
