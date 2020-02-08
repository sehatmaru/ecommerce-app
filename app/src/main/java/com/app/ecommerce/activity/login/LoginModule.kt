package com.app.ecommerce.activity.login

import com.app.network.sdk.NetworkSDK
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    internal fun provideMainView(activity: LoginActivity)
            : LoginContract.View {
        return activity
    }

    @Provides
    internal fun provideMainPresenter(view: LoginContract.View, networkSDK: NetworkSDK)
            : LoginPresenter {
        return LoginPresenter(view, networkSDK)
    }

}
