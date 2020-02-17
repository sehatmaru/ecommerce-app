package com.app.uicustom.view

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.list_item_bag.view.*


class ListItemBagViewKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                  @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var TAG = "NONE"
    private var listener: ListCategoryShopViewKGListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_bag, this)
        if (attrs != null) {
            try {
                val attributeArray = context.obtainStyledAttributes(
                        attrs,
                        R.styleable.ListItemBagViewKG)
                when (attributeArray.getInteger(R.styleable.ListItemBagViewKG_itemColor, 0)) {
                    3 -> {
                        tvColor.text = "Green"
                    }
                    0 -> {
                        tvColor.text = "Black"
                    }
                    1-> {
                        tvColor.text = "Navy"
                    }
                    2 -> {
                        tvColor.text = "Red"
                    }
                    else -> {}
                }
                when (attributeArray.getInteger(R.styleable.ListItemBagViewKG_itemSize, 0)) {
                    3 -> {
                        tvSize.text = "XL"
                    }
                    0 -> {
                        tvSize.text = "S"
                    }
                    1-> {
                        tvSize.text = "M"
                    }
                    2 -> {
                        tvSize.text = "L"
                    }
                    else -> {}
                }
                when (attributeArray.getInteger(R.styleable.ListItemBagViewKG_itemCat, 0)) {
                    0 -> {
                        setData("66", "1")
                        img.setImageResource(R.drawable.img_bag_1)
                    }
                    1-> {
                        setData("20", "1")
                        img.setImageResource(R.drawable.img_bag_2)
                    }
                    2 -> {
                        setData("5", "2")
                        img.setImageResource(R.drawable.img_bag_3)
                    }
                    else -> {}
                }
                attributeArray.recycle()
            } catch (e: Exception) {

            }
        }
    }

    private fun setData(cost: String, total: String){
        tvCost.text = "$cost$"
        tvTotal.text = total
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
