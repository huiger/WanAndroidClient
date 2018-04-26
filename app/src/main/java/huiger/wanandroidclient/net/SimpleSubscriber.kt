package huiger.wanandroidclient.net

import huiger.wanandroidclient.base.App
import huiger.wanandroidclient.utils.toast
import org.reactivestreams.Subscriber
import java.net.UnknownHostException



/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/20 18:22
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *
 ****************************************************************/
abstract class SimpleSubscriber<T: BaseResponse<T>> : Subscriber<T> {



    override fun onError(t: Throwable?) {
        when (t) {
            is UnknownHostException -> App().context?.toast("请打开网络")
        }


    }

    override fun onNext(t: T) {
        _onNext(t.data)
    }

    //    override fun onNext(result: BaseResponse<T>) {
//
//        _onNext(result.data)
//
//    }


    abstract fun _onNext(t: T)
}