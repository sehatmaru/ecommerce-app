package com.app.ecommerce.activity.login

import com.app.network.model.LoginRequest

class LoginContract {

    interface View {
        fun loading()
        fun dismissLoading()
        fun successLogin()
        fun failedLogin(message: String)
    }

    interface Presenter {
        fun login(request: LoginRequest)
    }
}
