package huiger.wanandroidclient.widgets

import android.content.Context
import android.support.v4.content.ContextCompat.getColor
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import huiger.wanandroidclient.R
import huiger.wanandroidclient.utils.dp2px
import kotlinx.android.synthetic.main.text_edit_layout.view.*

/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/25 17:32
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *
 ****************************************************************/
class Text_EditTextLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    var textColor: Int? = R.color.bg_color
    var textSize: Float? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.text_edit_layout, this, true)

        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.Text_EditTextLayout)

        textColor = typedArray?.getColor(R.styleable.Text_EditTextLayout_textColor, getColor(context, R.color.bg_color))
        textSize = typedArray?.getDimension(R.styleable.Text_EditTextLayout_textSize, 13f)

        tv_type.text = typedArray?.getText(R.styleable.Text_EditTextLayout_tv_type)
        et_input.hint = typedArray?.getText(R.styleable.Text_EditTextLayout_hintText)

        textSize?.let {
            tv_type.textSize = context?.dp2px(textSize!!)!!.toFloat()
            et_input.textSize = context.dp2px(textSize!!).toFloat()
        }

        textColor?.let {
            tv_type.setTextColor(getColor(context, textColor!!))
            et_input.setTextColor(getColor(context, textColor!!))
        }

        typedArray?.recycle()

    }


}