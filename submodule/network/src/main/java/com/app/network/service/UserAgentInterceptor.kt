package com.app.network.service;


import com.app.network.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

class UserAgentInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val appType = BuildConfig.APPLICATION_ID
        val versionName = BuildConfig.VERSION_NAME
        val versionCode = BuildConfig.VERSION_CODE.toString()
        val userAgent = "$appType/Android/$versionName/$versionCode"

        val requestBuilder = request.newBuilder()
                .addHeader(USER_AGENT, userAgent)
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }

    companion object {

        private val USER_AGENT = "User-Agent"
    }
}
