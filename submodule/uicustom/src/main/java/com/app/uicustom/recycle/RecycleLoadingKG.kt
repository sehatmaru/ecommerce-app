package com.app.uicustom.recycle

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.recycle_loading_view.view.*


class RecycleLoadingKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                 @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var cekListener: CekListener? = null
    val layoutManagerKG: LinearLayoutManager

    init {
        LayoutInflater.from(context).inflate(R.layout.recycle_loading_view, this)
        layoutManagerKG = LinearLayoutManager(context)
        recycler_view.setLayoutManager(layoutManagerKG)
        recycler_view.setItemAnimator(DefaultItemAnimator())
        val arr = getContext().obtainStyledAttributes(attrs,
                R.styleable.RecycleLoadingKG)
        try {
            val status = arr.getInt(R.styleable.RecycleLoadingKG_statusRecycle, LOADING)
            when (status) {
                LOADING -> loading()
                FAILED -> failed()
                SUCCESS -> success()
                else -> loading()
            }
        } finally {
            arr.recycle();
        }
    }

    fun setTryListener(cekListener_: CekListener) {
        this.cekListener = cekListener_
        txt_msg.setOnClickListener {
            loading()
            cekListener!!.tryAgain()
        }
    }

    interface CekListener {
        fun tryAgain()
    }

    fun success() {
        recycler_view.setVisibility(View.VISIBLE)
        progress.visibility = View.GONE
        txt_msg.visibility = View.GONE
    }

    fun loading() {
        recycler_view.setVisibility(View.GONE)
        progress.visibility = View.VISIBLE
        txt_msg.visibility = View.GONE
    }

    fun failed() {
        failed("")
    }

    fun failed(msg: String) {
        recycler_view.setVisibility(View.GONE)
        progress.visibility = View.GONE
        txt_msg.visibility = View.VISIBLE
        txt_msg.text = msg
    }

    fun emptyData(msg: String) {
        recycler_view.setVisibility(View.GONE)
        progress.visibility = View.GONE
        txt_msg.visibility = View.VISIBLE
        txt_msg.text = msg
    }

    fun setAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
        recycler_view.setAdapter(adapter)
    }

    fun getView(): RecyclerView{
        return recycler_view;
    }

    companion object {
        const val LOADING = 0
        const val FAILED = 1
        const val SUCCESS = 2
    }
}
