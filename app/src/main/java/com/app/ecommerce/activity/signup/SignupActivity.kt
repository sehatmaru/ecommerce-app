package com.app.ecommerce.activity.signup

import android.os.Bundle
import com.app.ecommerce.R
import com.app.ecommerce.activity.base.BaseActivity
import com.app.ecommerce.activity.login.LoginActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : BaseActivity(), SignupActivityContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        initListener()
    }

    companion object {
        private val TAG = "SignupActivity"
    }

    private fun initListener() {
        tvLogin.setOnClickListener { intoLogin() }
        iconLogin.setOnClickListener { intoLogin() }
    }

    private fun intoLogin(){
        startActivity(LoginActivity.newIntent(this))
    }

}
