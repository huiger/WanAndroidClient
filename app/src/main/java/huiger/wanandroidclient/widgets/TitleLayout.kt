package huiger.wanandroidclient.widgets

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import huiger.wanandroidclient.R
import kotlinx.android.synthetic.main.title_layout.view.*

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/19 15:38
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/
class TitleLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    init {

        LayoutInflater.from(context).inflate(R.layout.title_layout, this, true)
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.TitleLayout)

        tv_centre.text = typedArray?.getText(R.styleable.TitleLayout_centreText)
        val leftImgRes = typedArray?.getInt(R.styleable.TitleLayout_leftImage, -1)
        val rightImgRes = typedArray?.getInt(R.styleable.TitleLayout_rightImage, -1)
        typedArray?.recycle()


        if (leftImgRes != -1){
            iv_left.visibility = View.VISIBLE
            iv_left.setImageResource(leftImgRes!!)
        }

        if (rightImgRes != -1){
            iv_right.visibility = View.VISIBLE
            iv_right.setImageResource(rightImgRes!!)
        }

    }




}