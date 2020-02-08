package com.app.network.sdk;

import com.app.common.preference.LocalPreferences;
import com.app.network.networks.NetworkService;
import com.app.network.response.ResponseCallback
import io.reactivex.disposables.CompositeDisposable

class NetworkSDK(private val service: NetworkService, private val preferences: LocalPreferences) : Network {

}
