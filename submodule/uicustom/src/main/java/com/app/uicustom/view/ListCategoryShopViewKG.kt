package com.app.uicustom.view

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.list_category_shop.view.*
import kotlinx.android.synthetic.main.list_data_profile.view.*
import kotlinx.android.synthetic.main.list_data_profile.view.lyt
import kotlinx.android.synthetic.main.list_data_profile.view.tvTitle


class ListCategoryShopViewKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                       @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var TAG = "NONE"
    private var listener: ListCategoryShopViewKGListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.list_category_shop, this)
        if (attrs != null) {
            try {
                val attributeArray = context.obtainStyledAttributes(
                        attrs,
                        R.styleable.ListCategoryShopViewKG)
                when (attributeArray.getInteger(R.styleable.ListCategoryShopViewKG_categoryShop, 0)) {
                    3 -> {
                        tvTitle.text = "Accesories"
                        img.setImageResource(R.drawable.img_cat_4)
                    }
                    0 -> {
                        tvTitle.text = "New"
                        img.setImageResource(R.drawable.img_cat_1)
                    }
                    1-> {
                        tvTitle.text = "Clothes"
                        img.setImageResource(R.drawable.img_cat_2)
                    }
                    2 -> {
                        tvTitle.text = "Shoes"
                        img.setImageResource(R.drawable.img_cat_3)
                    }
                    else -> {}
                }
                attributeArray.recycle()
            } catch (e: Exception) {

            }
        }
    }

    fun setListCategoryShopViewKGListener(listener: ListCategoryShopViewKGListener, TAG: String) {
        this.TAG = TAG
        this.listener = listener

        lyt.setOnClickListener { listener.getListCategoryShopGeneralByTag(TAG) }
    }

    interface ListCategoryShopViewKGListener {
        fun getListCategoryShopGeneralByTag(TAG: String)
    }
}
