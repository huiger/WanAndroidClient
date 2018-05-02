package huiger.wanandroidclient.utils

import android.app.Activity
import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.Toast
import com.just.agentweb.AgentWeb
import com.just.agentweb.ChromeClientCallbackManager
import huiger.wanandroidclient.constans.Constans
import huiger.wanandroidclient.net.BaseResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/20 17:20
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc : 工具类
 *
 ****************************************************************/

/**
 * toast as context
 * @param id resId
 * @param duration time
 */
fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), duration)
}

/**
 * toast as Fragment
 * @param msg msg
 * @param duration time
 */
fun Fragment.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    toast(msg, duration)
}

/**
 * toast as Fragment
 * @param id msg
 * @param duration time
 */
fun Fragment.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), duration)
}

/**
 * toast as Activity
 * @param msg msg
 * @param duration time
 */
fun Activity.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    toast(msg, duration)
}

/**
 * toast as Activity
 * @param id msg
 * @param duration time
 */
fun Activity.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), duration)
}

/**
 * toast as context
 * @param msg msg
 * @param duration time
 */
fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Constans.showToast?.apply {
        setText(msg)
        show()
    } ?: run {
        Toast.makeText(this.applicationContext, msg, duration).apply {
            Constans.showToast = this
        }.show()

    }
}

/**
 * 减少重复写的次数
 */
fun <T> Observable<BaseResponse<T>>.io_main(): Observable<T>? {
    return subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { t -> t.data }
}

/**
 * dp -> px
 */
fun Context.dp2px(dpValue: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, resources.displayMetrics).toInt()
}

/**
 * sp -> px
 */
fun Context.sp2px(spValue: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, resources.displayMetrics).toInt()
}

/**
 * getAgentWeb
 */
fun String.getAgentWeb(
        activity: Activity, webContent: ViewGroup,
        layoutParams: ViewGroup.LayoutParams,
        receivedTitleCallback: ChromeClientCallbackManager.ReceivedTitleCallback?
) = AgentWeb.with(activity)//传入Activity or Fragment
        .setAgentWebParent(webContent, layoutParams)//传入AgentWeb 的父控件
        .useDefaultIndicator()// 使用默认进度条
        .defaultProgressBarColor() // 使用默认进度条颜色
        .setReceivedTitleCallback(receivedTitleCallback) //设置 Web 页面的 title 回调
        .createAgentWeb()//
        .ready()
        .go(this)!!

























