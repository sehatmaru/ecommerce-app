package com.app.ecommerce.activity.forgot

import dagger.Module
import dagger.Provides

@Module
class ForgotPasswordActivityModule {
    @Provides
    internal fun provideForgotPasswordView(activity: ForgotPasswordActivity)
            : ForgotPasswordActivityContract.View {
        return activity
    }

    @Provides
    internal fun provideForgotPasswordPresenter(view: ForgotPasswordActivityContract.View)
            : ForgotPasswordActivityPresenter {
        return ForgotPasswordActivityPresenter(view)
    }
}
