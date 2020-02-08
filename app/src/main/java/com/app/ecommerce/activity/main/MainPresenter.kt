package com.app.ecommerce.activity.main

import com.app.network.sdk.NetworkSDK
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(private val view: MainContract.View, private val networkSDK: NetworkSDK) : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
}
