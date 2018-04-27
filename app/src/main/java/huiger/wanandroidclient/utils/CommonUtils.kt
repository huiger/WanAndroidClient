package huiger.wanandroidclient.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import huiger.wanandroidclient.R
import huiger.wanandroidclient.base.App
import java.text.SimpleDateFormat
import java.util.*


/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/20 17:33
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *
 ****************************************************************/
object CommonUtils {

    fun showImage(context: Context, url: String?, iv: ImageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_banner_default)
                .error(R.mipmap.ic_banner_default)
                .into(iv)
    }

    /**
     * 获得状态栏高度
     *
     * @return
     */
    fun getStatusBarHeight(): Int {
        var result = 0
        val context = App().context
        val resourceId = App().context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }


    /**
     * 格式化时间字符串
     *
     * 今天/昨天/前天/data
     *
     */
    @SuppressLint("SimpleDateFormat")
    fun dataForMat(time: Long): String {

        val nowDate = Date(System.currentTimeMillis())
        val date = Date(time)

        val sdf = SimpleDateFormat("HH:mm:ss")
        val sdf2 = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")

        return when (nowDate.day - date.day) {
            0 -> "今天 " + sdf.format(time)
            1 -> "昨天 " + sdf.format(time)
            2 -> "前天 " + sdf.format(time)
            else -> "" + sdf2.format(time)
        }
    }


}
