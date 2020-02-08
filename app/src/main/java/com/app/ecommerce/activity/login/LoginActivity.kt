package com.app.ecommerce.activity.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.app.ecommerce.R
import com.app.ecommerce.activity.base.BaseActivity
import com.app.ecommerce.activity.forgot.ForgotPasswordActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        configureToolbar("", true)

        initListener()
    }

    companion object {
        private val TAG = "LoginActivity"

        @JvmStatic fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private fun initListener(){
        tvForgot.setOnClickListener { intoForgot() }
        iconForgot.setOnClickListener { intoForgot() }
    }

    private fun intoForgot(){
        startActivity(ForgotPasswordActivity.newIntent(this))
    }
}
