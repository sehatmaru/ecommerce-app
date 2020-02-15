package com.app.uicustom.view

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.list_data_profile.view.*


class ListDataProfileViewKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                      @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var TAG = "NONE"
    private var listener: ListDataProfileViewKGListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.list_data_profile, this)
        if (attrs != null) {
            try {
                val attributeArray = context.obtainStyledAttributes(
                        attrs,
                        R.styleable.ListDataProfileViewKG)
                val title = attributeArray.getString(R.styleable.ListDataProfileViewKG_titleProfile)
                val hint = attributeArray.getString(R.styleable.ListDataProfileViewKG_hintProfile)
                setText(title, hint)
                attributeArray.recycle()
            } catch (e: Exception) {

            }
        }
    }

    private fun setText(title: String, hint: String) {
        tvTitle.text = title
        tvHint.text = hint
    }

    fun setListDataProfileViewKGListener(listener: ListDataProfileViewKGListener, TAG: String) {
        this.TAG = TAG
        this.listener = listener

        lyt.setOnClickListener { listener.getListDataProfileGeneralByTag(TAG) }
    }

    interface ListDataProfileViewKGListener {
        fun getListDataProfileGeneralByTag(TAG: String)
    }
}
