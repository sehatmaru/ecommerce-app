package com.app.ecommerce.activity.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.ecommerce.R
import com.app.ecommerce.activity.base.BaseActivity
import com.app.ecommerce.activity.forgot.ForgotPasswordActivity
import com.app.ecommerce.activity.main.MainActivity
import com.app.network.model.LoginRequest
import com.app.uicustom.view.InputDataWithLabelViewKG
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginContract.View, InputDataWithLabelViewKG.InputDataWithLabelViewKGListener {

    @Inject lateinit var presenter: LoginPresenter
    private var request = LoginRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        configureToolbar("", true)

        initView()
        initListener()
    }

    companion object {
        private val TAG = "LoginActivity"
        private val EMAIL = "Email"
        private val PASSWORD = "Password"

        @JvmStatic fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private fun initView(){
        email.setInputDataWithLabelViewKGListener(this, EMAIL)
        password.setInputDataWithLabelViewKGListener(this, PASSWORD)
    }

    private fun initListener(){
        tvForgot.setOnClickListener { intoForgot() }
        iconForgot.setOnClickListener { intoForgot() }
        btnLogin.setOnClickListener { presenter.login(request) }
    }

    private fun intoForgot(){
        startActivity(ForgotPasswordActivity.newIntent(this))
    }

    override fun getInputDataGeneralByTag(value: String, TAG: String) {
        when(TAG){
            EMAIL -> request.email = value
            PASSWORD -> request.password = value
        }

        isValidButton()
    }

    private fun isValidButton() {
        if (request.isValid()) {
            btnLogin.setBackgroundResource(R.drawable.bg_rad25_colordb3022)
            btnLogin.isEnabled = true
        } else {
            btnLogin.setBackgroundResource(R.drawable.bg_rad25_color9eafbc)
            btnLogin.isEnabled = false
        }
    }

    override fun loading() {
        showLoading()
    }

    override fun dismissLoading() {
        cancelLoading()
    }

    override fun successLogin() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun failedLogin(message: String) {
        wrongLogin.visibility = View.VISIBLE
    }
}
