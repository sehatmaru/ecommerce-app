package com.app.ecommerce.activity.signup

import dagger.Module
import dagger.Provides

@Module
class SignupActivityModule {
    @Provides
    internal fun provideSignupView(activity: SignupActivity)
            : SignupActivityContract.View {
        return activity
    }

    @Provides
    internal fun provideSignupPresenter(view: SignupActivityContract.View)
            : SignupActivityPresenter {
        return SignupActivityPresenter(view)
    }
}
