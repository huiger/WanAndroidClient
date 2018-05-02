package huiger.wanandroidclient.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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


    /**
     * 沉浸式状态栏
     */
    fun initWindows(activity: Activity) {
        val window = activity.window
        //        int color = getResources().getColor(android.R.color.transparent);
//        val color = resources.getColor(android.R.color.black)
        val color = activity.resources.getColor(R.color.bg_color)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置状态栏颜色
            window.statusBarColor = color
            //设置导航栏颜色
            window.navigationBarColor = color
            val contentView = activity.findViewById<View>(android.R.id.content) as ViewGroup
            val childAt = contentView.getChildAt(0)
            if (childAt != null) {
                childAt.fitsSystemWindows = true
            }

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            //设置contentview为fitsSystemWindows
            val contentView = activity.findViewById<View>(android.R.id.content) as ViewGroup
            val childAt = contentView.getChildAt(0)
            if (childAt != null) {
                childAt.fitsSystemWindows = true
            }
            //给statusbar着色
            val view = View(activity)
            view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CommonUtils.getStatusBarHeight())
            view.setBackgroundColor(color)
            contentView.addView(view)
        }

    }

    /**
     * 透明状态栏
     */
    fun initTransWindows(activity: Activity) {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }
}
