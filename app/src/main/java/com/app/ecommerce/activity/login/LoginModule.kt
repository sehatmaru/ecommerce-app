package com.app.ecommerce.activity.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    internal fun provideMainView(activity: LoginActivity): LoginContract.View {
        return activity
    }

    @Provides
    internal fun provideMainPresenter(view: LoginContract.View): LoginPresenter {
        return LoginPresenter(view)
    }

}
