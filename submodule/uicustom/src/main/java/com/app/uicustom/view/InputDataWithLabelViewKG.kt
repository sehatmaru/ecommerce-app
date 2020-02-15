package com.app.uicustom.view

import android.content.Context
import android.support.annotation.AttrRes
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.uicustom.R
import kotlinx.android.synthetic.main.input_data_with_title.view.*


class InputDataWithLabelViewKG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                         @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var TAG = "NONE"
    private var listener: InputDataWithLabelViewKGListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.input_data_with_title, this)
        if (attrs != null) {
            try {
                val attributeArray = context.obtainStyledAttributes(
                        attrs,
                        R.styleable.InputDataWithLabelViewKG)
                val hint = attributeArray.getString(R.styleable.InputDataWithLabelViewKG_hintInputGeneral)
                setHint(hint)
                val maxInput = attributeArray.getInt(R.styleable.InputDataWithLabelViewKG_maxInputGeneral, 0)
                if (maxInput > 0) {
                    txtInputOne.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxInput))
                }
                when (attributeArray.getInteger(R.styleable.InputDataWithLabelViewKG_formatTypeGeneral, 0)) {
                    3 -> {
                        txtInputOne.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    }
                    2 -> {
                        txtInputOne.inputType = InputType.TYPE_CLASS_PHONE
                    }
                    1 -> {
                        txtInputOne.inputType = InputType.TYPE_CLASS_NUMBER
                    }
                    else -> {
                        txtInputOne.inputType = InputType.TYPE_CLASS_TEXT
                    }
                }
                if (attributeArray.getBoolean(R.styleable.InputDataWithLabelViewKG_isPassword, false)){
                    txtInputOne.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_SIGNED or InputType.TYPE_NUMBER_VARIATION_PASSWORD
                }
                txtInputOne.isEnabled = attributeArray.getBoolean(R.styleable.InputDataWithLabelViewKG_enableTypeOne, true)
                attributeArray.recycle()
            } catch (e: Exception) {

            }
        }
    }

    private fun setHint(hint: String?) {
        txtInputOneLyt.hint = hint
    }

    fun setText(txt: String) {
        txtInputOne.setText(txt)
    }

    fun getText() : String {
        return txtInputOne.text.toString()
    }

    fun setInputDataWithLabelViewKGListener(listener: InputDataWithLabelViewKGListener, TAG: String) {
        this.TAG = TAG
        this.listener = listener
        txtInputOne.addTextChangedListener(object : TextWatcher {

                    override fun afterTextChanged(s: Editable) {}

                    override fun beforeTextChanged(s: CharSequence, start: Int,
                                                   count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence, start: Int,
                                               before: Int, count: Int) {
                        listener.getInputDataGeneralByTag(s.toString(), TAG)
                    }
                })

    }

    interface InputDataWithLabelViewKGListener {
        fun getInputDataGeneralByTag(value: String, TAG: String)
    }
}
