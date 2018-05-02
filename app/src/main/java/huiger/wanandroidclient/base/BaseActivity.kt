package huiger.wanandroidclient.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import huiger.wanandroidclient.utils.CommonUtils


/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/19 9:33
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     blog : huiGer.top
 * *     *  * * * *     Desc : BaseActivity
 ****************************************************************/
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResId())

        CommonUtils.initWindows(this)

        initData()

        initListener()
    }

    protected abstract fun setLayoutResId(): Int

    protected abstract fun initData()

    protected abstract fun initListener()


}