package huiger.wanandroidclient.widgets

import android.content.Context
import android.graphics.Canvas
import android.support.annotation.IdRes
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import huiger.wanandroidclient.R
import huiger.wanandroidclient.utils.sp2px

/****************************************************************
 *
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/26 17:53
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc :
 *
 ****************************************************************/

class Text_EditTextLayout(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle) {

    private var tv_type: TextView? = null
    private var et_input: EditText? = null
    private val textColor: Int
    private val textSize: Float

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        initView(context)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Text_EditTextLayout)
        textColor = typedArray.getColor(R.styleable.Text_EditTextLayout_tet_textColor, ContextCompat.getColor(context, R.color.bg_color))
        textSize = typedArray.getDimensionPixelSize(R.styleable.Text_EditTextLayout_tet_textSize, context.sp2px(12f)).toFloat()
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        tv_type?.let {
            tv_type?.textSize = textSize
            tv_type?.setTextColor(textColor)
        }

        et_input?.let {
            et_input?.textSize = textSize
            et_input?.setTextColor(textColor)
        }
    }

    private fun initView(context: Context) {
        val rootView = LayoutInflater.from(context).inflate(R.layout.text_edit_layout, this)
        tv_type = rootView.findViewById(R.id.tv_type)
        et_input = rootView.findViewById(R.id.et_input)
    }

    fun setTextColor(@IdRes color: Int) {
        tv_type!!.setTextColor(color)
        et_input!!.setTextColor(color)
    }

    fun setTextSize(textSize: Int) {
        tv_type!!.textSize = textSize.toFloat()
        et_input!!.textSize = textSize.toFloat()
    }
}
