package com.app.network.networks;


import com.app.common.preference.LocalPreferences;
import com.app.network.response.ResponseCallback
import com.app.network.rx.BaseSchedulerProvider;
import io.reactivex.disposables.Disposable

class NetworkService(private val service: Service, private val localPreferences: LocalPreferences,
                      private val schedulers: BaseSchedulerProvider) {
}
