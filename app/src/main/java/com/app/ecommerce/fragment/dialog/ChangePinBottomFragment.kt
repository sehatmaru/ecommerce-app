package com.app.ecommerce.fragment.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.WindowManager
import com.app.ecommerce.R
import kotlinx.android.synthetic.main.fragment_bottom_change_pin.view.*

class ChangePinBottomFragment : BottomSheetDialogFragmentAllowingStateLoss(){

    private var mBehavior: BottomSheetBehavior<View>? = null
    private var rootView: View? = null
    private var listener: ChangePinBottomFragmentListener? = null

    private val mBottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(@NonNull bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismissAllowingStateLoss()
            }
        }

        override fun onSlide(@NonNull bottomSheet: View, slideOffset: Float) {}
    }

    companion object {

        @JvmStatic fun newInstance(): ChangePinBottomFragment {
            val fragment = ChangePinBottomFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        val view = View.inflate(context, R.layout.fragment_bottom_change_pin, null)
        dialog.setContentView(view)

        mBehavior = BottomSheetBehavior.from(view.parent as View)
        mBehavior?.apply {
            setBottomSheetCallback(mBottomSheetBehaviorCallback)
            skipCollapsed = true
        }
        rootView = view
        initAction()
        return dialog
    }

    private fun initAction() {
        val layoutManager = LinearLayoutManager(activity)
//        rootView?.btnExit?.setOnClickListener{
//            dismiss()
//        }
//        rootView?.btnNext?.setOnClickListener{
//            listener?.onClickNextButtonBottomFragment()
//        }
    }

    override fun onStart() {
        super.onStart()
        mBehavior?.apply {
            setState(BottomSheetBehavior.STATE_EXPANDED)
        }
    }

    fun setChangePinBottomFragmentListener(listener: ChangePinBottomFragmentListener){
        this.listener = listener

        rootView?.forgotPin?.setOnClickListener {
            listener.onClickForgotPinBottomFragment()
        }
    }

    interface ChangePinBottomFragmentListener{
        fun onClickForgotPinBottomFragment()
    }

}
