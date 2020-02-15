package com.app.ecommerce.activity.profile.settings

import com.app.network.sdk.NetworkSDK
import dagger.Module
import dagger.Provides

@Module
class SettingsActivityModule {
    @Provides
    internal fun provideSettingsView(activity: SettingsActivity): SettingsActivityContract.View {
        return activity
    }

    @Provides
    internal fun provideSettingsPresenter(view: SettingsActivityContract.View, networkSDK: NetworkSDK): SettingsActivityPresenter {
        return SettingsActivityPresenter(view, networkSDK)
    }
}