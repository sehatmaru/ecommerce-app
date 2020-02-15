package com.app.ecommerce.fragment.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.ecommerce.R
import com.app.ecommerce.activity.profile.settings.SettingsActivity
import com.app.uicustom.view.ListDataProfileViewKG
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : Fragment(), ProfileFragmentContract.View, ListDataProfileViewKG.ListDataProfileViewKGListener {

    @Inject lateinit var presenter: ProfileFragmentPresenter

    companion object {
        const val SETTINGS = "SETTINGS"

        @JvmStatic fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        settings.setListDataProfileViewKGListener(this, SETTINGS)
    }

    override fun getListDataProfileGeneralByTag(TAG: String) {
        when(TAG){
            SETTINGS -> startActivity(SettingsActivity.newIntent(requireContext()))
        }
    }
}
