package com.app.ecommerce.fragment.home

import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {
    @Provides
    internal fun provideHomeView(fragment: HomeFragment): HomeFragmentContract.View {
        return fragment
    }

    @Provides
    internal fun provideHomePresenter(view: HomeFragmentContract.View): HomeFragmentPresenter {
        return HomeFragmentPresenter(view)
    }
}
