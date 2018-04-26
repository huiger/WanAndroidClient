package huiger.wanandroidclient.widgets

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import huiger.wanandroidclient.R
import huiger.wanandroidclient.base.BaseFragment
import kotlinx.android.synthetic.main.view_tabitem.view.*

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/19 17:50
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc : 首页Fragment切换
 ****************************************************************/
class TabItem<T : BaseFragment>(context: Context, attrs: AttributeSet?, defStyleAttr: Int, fragmentClass: Class<T>?) : LinearLayout(context, attrs, defStyleAttr) {

    private var tip: String? = null
    private var selectColor: Int
    private var unSelectColor: Int
    private var selectIcon: Drawable? = null
    private var unSelectIcon: Drawable? = null

    private var isSelect = false

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)
    constructor(context: Context, fragmentClass: Class<T>) : this(context, null, 0, fragmentClass)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_tabitem, this, true)

        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.TabItem)
        tip = typeArray?.getString(R.styleable.TabItem_tip)
        selectColor = typeArray.getColor(R.styleable.TabItem_selectColor, Color.BLACK)
        unSelectColor = typeArray.getColor(R.styleable.TabItem_unSelectColor, ContextCompat.getColor(context, R.color.gray))
        selectIcon = typeArray?.getDrawable(R.styleable.TabItem_selectIcon)
        unSelectIcon = typeArray?.getDrawable(R.styleable.TabItem_unSelectIcon)
        typeArray?.recycle()

        orientation = VERTICAL
        gravity = Gravity.CENTER
        setPadding(8, 8, 8, 8)

        if (fragmentClass != null) {
            tag = fragmentClass.name
        }

        show()
    }

    fun setTip(str: String) {
        tip = str
    }

    fun setColor(select: Int, unSelect: Int) {
        selectColor = select
        unSelectColor = unSelect
    }

    fun setIcon(select: Drawable, unSelect: Drawable) {
        selectIcon = select
        unSelectIcon = unSelect
    }

    fun isSelect(select: Boolean) {
        isSelect = select
        show()
    }

    private fun show() {
        name.text = tip
        if (isSelect) {
            name.setTextColor(selectColor)
            image.scaleX = 1.2f
            image.scaleY = 1.2f
            image.setImageDrawable(selectIcon)
        } else {
            name.setTextColor(unSelectColor)
            image.scaleX = 1.0f
            image.scaleY = 1.0f
            image.setImageDrawable(unSelectIcon)
        }
    }



}