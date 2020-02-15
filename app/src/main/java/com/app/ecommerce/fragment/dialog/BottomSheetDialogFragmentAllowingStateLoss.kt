package com.app.ecommerce.fragment.dialog

import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.app.ecommerce.R

open class BottomSheetDialogFragmentAllowingStateLoss: BottomSheetDialogFragment() {

    companion object {
        private const val TAG = "BottomSheetFragment"
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun show(manager: FragmentManager?, tag: String?) {
        try {
            manager?.apply {
                val fragmentTransaction = beginTransaction()
                fragmentTransaction
                        .add(this@BottomSheetDialogFragmentAllowingStateLoss, tag)
                fragmentTransaction.commitAllowingStateLoss()
            }
        } catch (illegalEx: IllegalStateException) {
            Log.e(TAG, "Exception when show dialog", illegalEx)
        }
    }
}