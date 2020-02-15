package com.app.ecommerce.fragment.shop

import dagger.Module
import dagger.Provides

@Module
class ShopFragmentModule {
    @Provides
    internal fun provideShopView(fragment: ShopFragment): ShopFragmentContract.View {
        return fragment
    }

    @Provides
    internal fun provideShopPresenter(view: ShopFragmentContract.View): ShopFragmentPresenter {
        return ShopFragmentPresenter(view)
    }
}
