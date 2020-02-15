package com.app.ecommerce.fragment.bag

import dagger.Module
import dagger.Provides

@Module
class BagFragmentModule {
    @Provides
    internal fun provideBagView(fragment: BagFragment): BagFragmentContract.View {
        return fragment
    }

    @Provides
    internal fun provideBagPresenter(view: BagFragmentContract.View): BagFragmentPresenter {
        return BagFragmentPresenter(view)
    }
}
