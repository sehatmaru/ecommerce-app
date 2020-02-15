package com.app.ecommerce.deps

import com.app.ecommerce.fragment.bag.BagFragment
import com.app.ecommerce.fragment.bag.BagFragmentModule
import com.app.ecommerce.fragment.favorites.FavoritesFragment
import com.app.ecommerce.fragment.favorites.FavoritesFragmentModule
import com.app.ecommerce.fragment.home.HomeFragment
import com.app.ecommerce.fragment.home.HomeFragmentModule
import com.app.ecommerce.fragment.profile.ProfileFragment
import com.app.ecommerce.fragment.profile.ProfileFragmentModule
import com.app.ecommerce.fragment.shop.ShopFragment
import com.app.ecommerce.fragment.shop.ShopFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    internal abstract fun homeFragment(): HomeFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [BagFragmentModule::class])
    internal abstract fun bagFragment(): BagFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [FavoritesFragmentModule::class])
    internal abstract fun favoritesFragment(): FavoritesFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ShopFragmentModule::class])
    internal abstract fun shopFragment(): ShopFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    internal abstract fun profileFragment(): ProfileFragment
}
