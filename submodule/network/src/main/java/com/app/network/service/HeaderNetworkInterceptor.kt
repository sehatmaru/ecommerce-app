package com.app.network.service;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

class HeaderNetworkInterceptor(private val tokenProvider: AuthProvider, private val context: Context) : Interceptor {

    @SuppressLint("HardwareIds")
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val builder = StringBuilder("token=")
        builder.append(tokenProvider.token)

        val requestBuilder = request.newBuilder()
                .addHeader(AUTHORIZATION, builder.toString())
        if (!tokenProvider.userId.isEmpty()) {
            requestBuilder.addHeader(USERID, tokenProvider.userId)
        }

        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }

    companion object {

        private val AUTHORIZATION = "token"
        internal val USERID = "userId"
    }

}
