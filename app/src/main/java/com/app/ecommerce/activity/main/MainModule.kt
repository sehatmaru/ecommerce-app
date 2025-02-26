package com.app.ecommerce.activity.main

import com.app.network.sdk.NetworkSDK
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    internal fun provideMainView(activity: MainActivity)
            : MainContract.View {
        return activity
    }

    @Provides
    internal fun provideMainPresenter(view: MainContract.View, networkSDK: NetworkSDK)
            : MainPresenter {
        return MainPresenter(view, networkSDK)
    }

}
