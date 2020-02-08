package com.app.ecommerce.deps

import com.app.ecommerce.activity.forgot.ForgotPasswordActivity
import com.app.ecommerce.activity.forgot.ForgotPasswordActivityModule
import com.app.ecommerce.activity.login.LoginActivity
import com.app.ecommerce.activity.login.LoginModule
import com.app.ecommerce.activity.main.MainActivity
import com.app.ecommerce.activity.main.MainModule
import com.app.ecommerce.activity.signup.SignupActivity
import com.app.ecommerce.activity.signup.SignupActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SignupActivityModule::class])
    internal abstract fun signupActivity(): SignupActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ForgotPasswordActivityModule::class])
    internal abstract fun forgotPasswordActivity(): ForgotPasswordActivity
}
