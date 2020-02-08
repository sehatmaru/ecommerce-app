package com.app.ecommerce.activity.login

import com.app.network.sdk.NetworkSDK
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter(private val view: LoginContract.View, private val networkSDK: NetworkSDK) : LoginContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

}
