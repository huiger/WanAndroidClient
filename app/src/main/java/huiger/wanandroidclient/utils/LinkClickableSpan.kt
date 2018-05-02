package huiger.wanandroidclient.utils

import android.content.Context
import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View

/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/27 11:58
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc : link Click
 *
 ****************************************************************/
class LinkClickableSpan(val context: Context, val url: String) : ClickableSpan() {

    override fun updateDrawState(ds: TextPaint?) {
        super.updateDrawState(ds)
        ds?.color = Color.parseColor("#2782ef")
        ds?.isUnderlineText = true  // 下划线
    }

    override fun onClick(p0: View?) {
        context.toast(url)
        Log.d("msg", "LinkClickableSpan -> onClick: " + url)
    }
}