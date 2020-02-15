package com.app.ecommerce.fragment.bag

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.ecommerce.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BagFragment : Fragment(), BagFragmentContract.View {

    @Inject lateinit var presenter: BagFragmentPresenter

    companion object {

        @JvmStatic fun newInstance(): BagFragment {
            val fragment = BagFragment()
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
        return inflater.inflate(R.layout.fragment_bag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFunction()
    }

    private fun initFunction() {

    }
}
