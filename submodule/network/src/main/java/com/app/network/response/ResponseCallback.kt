package com.app.network.response;

interface ResponseCallback<T> {
    fun onError(throwable: Throwable)
    fun onSuccess(response: T)
}
