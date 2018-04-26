package huiger.wanandroidclient.base

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import huiger.wanandroidclient.BuildConfig
import huiger.wanandroidclient.utils.PreferenceUtils

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/19 10:56
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/
class App : Application() {

    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        PreferenceUtils.setContext(applicationContext)

        context = applicationContext


        initLog()
    }

    private fun initLog() {
        Logger.addLogAdapter(AndroidLogAdapter {
            priority, tag, message ->
            BuildConfig.DEBUG
        })
    }


}