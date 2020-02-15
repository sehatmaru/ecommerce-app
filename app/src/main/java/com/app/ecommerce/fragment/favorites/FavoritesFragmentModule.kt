package com.app.ecommerce.fragment.favorites

import dagger.Module
import dagger.Provides

@Module
class FavoritesFragmentModule {
    @Provides
    internal fun provideFavoritesView(fragment: FavoritesFragment): FavoritesFragmentContract.View {
        return fragment
    }

    @Provides
    internal fun provideFavoritesPresenter(view: FavoritesFragmentContract.View): FavoritesFragmentPresenter {
        return FavoritesFragmentPresenter(view)
    }
}
