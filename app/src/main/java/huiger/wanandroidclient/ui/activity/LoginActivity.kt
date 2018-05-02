package huiger.wanandroidclient.ui.activity

import android.view.View
import huiger.wanandroidclient.R
import huiger.wanandroidclient.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun setLayoutResId(): Int= R.layout.activity_login

    override fun initData() {

    }

    override fun initListener() {

    }

    private val clickListener : View.OnClickListener = View.OnClickListener { v->

        when(v){
            iv_back -> finish()

        }
    }

}
