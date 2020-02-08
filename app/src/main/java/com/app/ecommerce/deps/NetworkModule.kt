package com.app.ecommerce.deps;

import android.content.Context;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;
import com.app.ecommerce.R;
import com.app.common.preference.LocalPreferences;
import com.app.network.networks.Endpoint;
import com.app.network.networks.NetworkEndpoint;
import com.app.network.networks.Service;
import com.app.network.networks.NetworkService;
import com.app.network.rx.SchedulerProvider;
import com.app.network.sdk.NetworkSDK;
import com.app.network.service.AuthProvider;
import com.app.network.service.AuthSession;
import com.app.network.service.HeaderNetworkInterceptor;
import com.app.network.service.UserAgentInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptorLevel(context: Context): HttpLoggingInterceptor.Level {
        val level = context.getString(R.string.okhttp_log_level)
        when (level) {
            "NONE" -> return HttpLoggingInterceptor.Level.NONE
            "BASIC" -> return HttpLoggingInterceptor.Level.BASIC
            "HEADERS" -> return HttpLoggingInterceptor.Level.HEADERS
            "BODY" -> return HttpLoggingInterceptor.Level.BODY
            else -> return HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(logLevel: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(logLevel)
    }

    @Provides
    @Singleton
    internal fun provideAuthSession(localPreferences: LocalPreferences): AuthProvider {
        return AuthSession(localPreferences)
    }

    @Provides
    @Singleton
    fun providesHeaderNetworkInterceptor(context: Context, tokenProvider: AuthProvider): HeaderNetworkInterceptor {
        return HeaderNetworkInterceptor(tokenProvider, context)
    }

    @Provides
    @Singleton
    fun providesUserAgentInterceptor(): UserAgentInterceptor {
        return UserAgentInterceptor()
    }

    @Provides
    @Singleton
    @Named("AuthOkHttp")
    fun providesAuthOkHttpClient(context: Context,
                                 loggingInterceptor: HttpLoggingInterceptor,
                                 networkInterceptor: HeaderNetworkInterceptor,
                                 userAgentInterceptor: UserAgentInterceptor): OkHttpClient {
        val cacheDir = File(context.cacheDir, "http-auth_cache")
        val cache = Cache(cacheDir, (1024 * 1024 * 10).toLong())

        return OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(networkInterceptor)
                .addInterceptor(userAgentInterceptor)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    @Named("Endpoint")
    internal fun provideEndpoint(context: Context): Endpoint {
        return NetworkEndpoint(context)
    }

    @Provides
    @Singleton
    @Named("Retrofit")
    internal fun provideRetrofit(@Named("AuthOkHttp") okHttpClient: OkHttpClient,
                                 @Named("Endpoint") endpoint: Endpoint): Retrofit {
        return Retrofit.Builder()
                .baseUrl(endpoint.endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(LoganSquareConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideService(@Named("Retrofit") retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

    @Provides
    @Singleton
    internal fun provideNetworkService(service: Service, localPreferences: LocalPreferences): NetworkService {
        return NetworkService(service, localPreferences, SchedulerProvider.getInstance())
    }


    @Provides
    @Singleton
    internal fun provideNetworkSDK(service: NetworkService, localPreferences: LocalPreferences): NetworkSDK {
        return NetworkSDK(service, localPreferences)
    }

}
