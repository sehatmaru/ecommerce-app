package com.app.uicustom.loading

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.loading_gojek_view.view.*


class LoadingKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                          @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var loadingListener: LoadingListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.loading_gojek_view, this)
        val arr = getContext().obtainStyledAttributes(attrs,
                R.styleable.LoadingKG)
        try {
            val anim = arr.getBoolean(R.styleable.LoadingKG_anim, true)
            if (anim) {
                val rotation = AnimationUtils.loadAnimation(context, R.anim.rotate)
                imgLoading.startAnimation(rotation)
            }
            val messageFailed = arr.getString(R.styleable.LoadingKG_messageFailed)
            txtMessageFailed.text = messageFailed
            val status = arr.getInt(R.styleable.LoadingKG_statusLoading, LOADING)
            when (status) {
                LOADING -> loading()
                FAILED -> failed()
                DISMISS -> dismiss()
                else -> loading()
            }
        } finally {
            arr.recycle();
        }
    }

    fun setLoadingListener(loadingListener_: LoadingListener) {
        this.loadingListener = loadingListener_
        btnRetry.setOnClickListener({
            loadingListener!!.retry()
        })
    }

    interface LoadingListener {
        fun retry()
    }

    fun dismiss() {
        visibility = View.GONE
    }

    fun failed() {
        visibility = View.VISIBLE
        lytFailed.visibility = View.VISIBLE
        lytLoading.visibility = View.GONE
    }

    fun loading() {
        visibility = View.VISIBLE
        lytLoading.visibility = View.VISIBLE
        lytFailed.visibility = View.GONE
    }

    fun failed(msg: String) {
        txtMessageFailed.text = msg
        failed()
    }

    companion object {
        const val LOADING = 0
        const val FAILED = 1
        const val DISMISS = 2
    }
}
