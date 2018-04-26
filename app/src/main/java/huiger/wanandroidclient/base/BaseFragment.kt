package huiger.wanandroidclient.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/19 9:33
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     blog : huiGer.top
 * *     *  * * * *     Desc : BaseActivity
 ****************************************************************/
abstract class BaseFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(setLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    protected abstract fun setLayoutResId(): Int

    protected abstract fun initData()


//    private var toast: Toast? = null
//    /**
//     * 消息toast
//     * ---------扩展函数
//     * ---------?是不为空执行。!!是可以执行，但是如果为空会抛出空指针
//     */
//    @SuppressLint("ShowToast")
//    fun BaseFragment.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
//
//        if (toast == null) {
//            toast = Toast.makeText(activity, msg, duration)
//        } else {
//            toast?.setText(msg)
//        }
//        toast?.show()
////        toast!!.show()
//    }
}