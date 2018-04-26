package huiger.wanandroidclient.base

import huiger.wanandroidclient.utils.toast

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 14:05
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc : BaseView
 ****************************************************************/
interface BaseView {

    fun <T> loadSuccess(data : T)

    fun loadFail(e : Throwable)
}