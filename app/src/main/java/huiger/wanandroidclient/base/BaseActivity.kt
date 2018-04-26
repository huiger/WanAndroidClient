package huiger.wanandroidclient.base

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import huiger.wanandroidclient.R
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

        initWindows()

        initData()


    }

    protected abstract fun setLayoutResId(): Int

    protected abstract fun initData()


    /**
     * 沉浸式状态栏
     */
    fun initWindows() {
        val window = window
        //        int color = getResources().getColor(android.R.color.transparent);
//        val color = resources.getColor(android.R.color.black)
        val color = resources.getColor(R.color.bg_color)
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
            val contentView = findViewById<View>(android.R.id.content) as ViewGroup
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
            val contentView = findViewById<View>(android.R.id.content) as ViewGroup
            val childAt = contentView.getChildAt(0)
            if (childAt != null) {
                childAt.fitsSystemWindows = true
            }
            //给statusbar着色
            val view = View(this)
            view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CommonUtils().getStatusBarHeight())
            view.setBackgroundColor(color)
            contentView.addView(view)
        }

    }

    /**
     * 透明状态栏
     */
    fun initTransWindows() {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }




}