package com.app.ecommerce.activity.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.ecommerce.R
import dagger.android.AndroidInjection
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    companion object {
        private val TAG = "LoginActivity"
    }
}
