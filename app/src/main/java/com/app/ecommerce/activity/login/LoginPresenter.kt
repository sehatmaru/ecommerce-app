package com.app.ecommerce.activity.login

import com.app.common.utils.AuthIdentity
import com.app.network.model.LoginRequest
import com.app.network.sdk.NetworkSDK
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun login(request: LoginRequest) {
        view.loading()

        if (request.email == AuthIdentity.EMAIL && request.password == AuthIdentity.PASSWORD) view.successLogin()
        else view.failedLogin("Wrong Email/Password")

        view.dismissLoading()
    }
}
