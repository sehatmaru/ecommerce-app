package com.app.network.model

class LoginRequest {
    var email: String = ""
    var password: String = ""

    fun isValid(): Boolean{
        return email.isNotEmpty()
                && password.isNotEmpty()
                && (password.length >= 6)
                && email.contains("gmail.com")
    }
}