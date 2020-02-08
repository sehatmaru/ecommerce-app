package com.app.ecommerce.activity.forgot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.app.ecommerce.R
import com.app.ecommerce.activity.base.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordActivityContract.View {

    @Inject
    lateinit var presenter: ForgotPasswordActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        configureToolbar("", true)

    }

    companion object {
        private val TAG = "LoginActivity"

        @JvmStatic fun newIntent(context: Context): Intent {
            return Intent(context, ForgotPasswordActivity::class.java)
        }
    }
}
