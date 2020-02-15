package com.app.uicustom.tab

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.nav_bar_bottom.view.*


class NavBarBottomViewKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                   @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var listener: NavBarBottomViewKGListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.nav_bar_bottom, this)
        setPositionTab(1)
        btn1.setOnClickListener{
            setPositionTab(1)
        }
        btn2.setOnClickListener{
            setPositionTab(2)
        }
        btn3.setOnClickListener{
            setPositionTab(3)
        }
        btn4.setOnClickListener{
            setPositionTab(4)
        }
        btn5.setOnClickListener{
            setPositionTab(5)
        }
    }

    fun setPositionTab(position: Int) {
        img1.setImageResource(R.drawable.home_icon_inactive)
        img2.setImageResource(R.drawable.shop_icon_inactive)
        img3.setImageResource(R.drawable.shopping_bag_icon_inactive)
        img4.setImageResource(R.drawable.heart_icon_inactive)
        img5.setImageResource(R.drawable.profile_icon_inactive)
        txt1.setTextColor(resources.getColor(R.color.color9b9b9b))
        txt2.setTextColor(resources.getColor(R.color.color9b9b9b))
        txt3.setTextColor(resources.getColor(R.color.color9b9b9b))
        txt4.setTextColor(resources.getColor(R.color.color9b9b9b))
        txt5.setTextColor(resources.getColor(R.color.color9b9b9b))
        when (position) {
            1 -> {
                img1.setImageResource(R.drawable.home_icon_activated)
                txt1.setTextColor(resources.getColor(R.color.colordb3022))
            }
            2 -> {
                img2.setImageResource(R.drawable.shop_icon_activated)
                txt2.setTextColor(resources.getColor(R.color.colordb3022))
            }
            3 -> {
                img3.setImageResource(R.drawable.shopping_bag_icon_activated)
                txt3.setTextColor(resources.getColor(R.color.colordb3022))
            }
            4 -> {
                img4.setImageResource(R.drawable.heart_icon_activated)
                txt4.setTextColor(resources.getColor(R.color.colordb3022))
            }
            5 -> {
                img5.setImageResource(R.drawable.profile_icon_activated)
                txt5.setTextColor(resources.getColor(R.color.colordb3022))
            }
        }
        if (this.listener != null) {
            this.listener!!.onClickNavbarByPosition(position)
        }
    }

    fun setNavBarBottomViewKGListener(listener: NavBarBottomViewKGListener){
        this.listener = listener
    }
    interface NavBarBottomViewKGListener {
        fun onClickNavbarByPosition(position: Int)
    }

}
