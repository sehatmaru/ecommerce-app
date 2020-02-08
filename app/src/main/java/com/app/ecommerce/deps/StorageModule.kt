package com.app.ecommerce.deps;

import android.content.Context;


import com.app.ecommerce.BuildConfig;
import com.app.common.preference.LocalPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class StorageModule {

    @Provides
    @Singleton
    fun providesLocalPreferences(context: Context): LocalPreferences {
        return LocalPreferences(context, BuildConfig.APPLICATION_ID)
    }

}
