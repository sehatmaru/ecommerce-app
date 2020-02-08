package com.app.network.networks;


import android.content.Context;

import com.app.network.R;


class NetworkEndpoint(private val context: Context) : Endpoint {

    override val endpoint: String
        get() = context.getString(R.string.base_url)
}
