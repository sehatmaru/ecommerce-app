package com.app.ecommerce.activity.profile.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.app.ecommerce.R
import com.app.ecommerce.activity.base.BaseActivity
import com.app.ecommerce.activity.forgot.ForgotPasswordActivity
import com.app.ecommerce.fragment.dialog.ChangePinBottomFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : BaseActivity(), SettingsActivityContract.View {

    @Inject lateinit var presenter: SettingsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        configureToolbar("", true)

        initListener()
    }

    companion object {

        @JvmStatic fun newIntent(context: Context): Intent {
            return Intent(context, SettingsActivity::class.java)
        }
    }

    private fun initListener(){
        changePin.setOnClickListener {
            val dialogFragment = ChangePinBottomFragment.newInstance()
            dialogFragment.setChangePinBottomFragmentListener(object: ChangePinBottomFragment.ChangePinBottomFragmentListener {
                override fun onClickForgotPinBottomFragment() {
                    startActivity(ForgotPasswordActivity.newIntent(baseContext))
                }
            })

            dialogFragment.show(supportFragmentManager, dialogFragment.tag)
        }
    }
}
