package huiger.wanandroidclient.ui.fragment

import android.content.Intent
import android.view.View
import huiger.wanandroidclient.R
import huiger.wanandroidclient.base.BaseFragment
import huiger.wanandroidclient.constans.Constans
import huiger.wanandroidclient.ui.activity.LoginActivity
import huiger.wanandroidclient.utils.PreferenceUtils
import kotlinx.android.synthetic.main.fragment_mine_layout.*

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 9:16
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/
class MineFragment : BaseFragment() {


    private val loginStatus: Boolean by PreferenceUtils(Constans.LOGIN_STATUS, false)

    override fun setLayoutResId(): Int = R.layout.fragment_mine_layout

    override fun initData() {
        tv_user_name.setOnClickListener(onListener)


        if (!loginStatus){  // 未登录
            tv_user_name.text = "未登录, 请登录!"
        }else{
            TODO()



        }


    }


    private val onListener: View.OnClickListener = View.OnClickListener { v ->
        when(v){
            tv_user_name -> {
                startActivity(Intent(activity, LoginActivity::class.java))
            }
        }
    }

}