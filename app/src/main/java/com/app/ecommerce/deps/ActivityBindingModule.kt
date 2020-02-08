package com.app.ecommerce.deps

import com.app.ecommerce.activity.login.LoginActivity
import com.app.ecommerce.activity.login.LoginModule
import com.app.ecommerce.activity.main.MainActivity
import com.app.ecommerce.activity.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun mainActivity(): MainActivity

}
