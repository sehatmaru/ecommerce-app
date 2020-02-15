package com.app.ecommerce.activity.main

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import com.app.ecommerce.R
import com.app.ecommerce.activity.base.BaseActivity
import com.app.ecommerce.adapter.MainAdapter
import com.app.ecommerce.fragment.bag.BagFragment
import com.app.ecommerce.fragment.favorites.FavoritesFragment
import com.app.ecommerce.fragment.home.HomeFragment
import com.app.ecommerce.fragment.profile.ProfileFragment
import com.app.ecommerce.fragment.shop.ShopFragment
import com.app.uicustom.tab.NavBarBottomViewKG
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector, MainContract.View, NavBarBottomViewKG.NavBarBottomViewKGListener {

    @Inject lateinit var presenter: MainPresenter
    private val fragments = LinkedList<Fragment>()
    @Inject lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.colorf01f0e)
        }
        val step1 = HomeFragment.newInstance()
        val step2 = ShopFragment.newInstance()
        val step3 = BagFragment.newInstance()
        val step4 = FavoritesFragment.newInstance()
        val step5 = ProfileFragment.newInstance()
        fragments.add(step1)
        fragments.add(step2)
        fragments.add(step3)
        fragments.add(step4)
        fragments.add(step5)
        adapter = MainAdapter(supportFragmentManager, fragments)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = PAGE_LIMIT
        navBar.setNavBarBottomViewKGListener(this)
    }

    companion object {
        private val TAG = "MainActivity"
        const val PAGE_LIMIT = 5
        @JvmStatic fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onClickNavbarByPosition(position: Int) {
        if (position == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = resources.getColor(R.color.colorf01f0e)
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = resources.getColor(R.color.baseColorPrimary)
            }
        }
        viewPager.currentItem = position-1
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}
