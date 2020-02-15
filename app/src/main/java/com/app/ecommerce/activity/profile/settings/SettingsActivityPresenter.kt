package com.app.ecommerce.activity.profile.settings

import com.app.network.sdk.NetworkSDK

class SettingsActivityPresenter (private val view: SettingsActivityContract.View,
                                 private val networkSDK: NetworkSDK) : SettingsActivityContract.Presenter
