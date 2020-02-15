package com.app.ecommerce.fragment.profile

import dagger.Module
import dagger.Provides

@Module
class ProfileFragmentModule {
    @Provides
    internal fun provideProfileView(fragment: ProfileFragment): ProfileFragmentContract.View {
        return fragment
    }

    @Provides
    internal fun provideProfilePresenter(view: ProfileFragmentContract.View): ProfileFragmentPresenter {
        return ProfileFragmentPresenter(view)
    }
}
