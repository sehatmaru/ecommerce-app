package com.app.ecommerce.activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.ecommerce.R
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View{

    @Inject lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
