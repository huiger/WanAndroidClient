package huiger.wanandroidclient

import android.support.v4.app.Fragment
import android.view.View
import huiger.wanandroidclient.base.BaseActivity
import huiger.wanandroidclient.base.BaseFragment
import huiger.wanandroidclient.widgets.TabItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    //    三钟写法
//    override fun setLayoutResId(): Int {
//        return R.layout.activity_main
//    }
//     override fun setLayoutResId():Int = R.layout.activity_main
    override fun setLayoutResId() = R.layout.activity_main


    override fun initData() {

        tab_index.setOnClickListener(tabClickListener)
        tab_tree.setOnClickListener(tabClickListener)
        tab_project.setOnClickListener(tabClickListener)
        tab_mine.setOnClickListener(tabClickListener)

        tab_index.performClick()

    }

    private var currentFragmentTag: String? = null
    private var lastClickView : TabItem<BaseFragment> ?= null

    private var tabClickListener = View.OnClickListener { v  ->
        v as TabItem<BaseFragment>
//        var tempView = v as TabItem<BaseFragment>

        var fragmentClass = Class.forName(v.tag.toString())
        val transaction = supportFragmentManager.beginTransaction()
        val fragmentByTag = supportFragmentManager.findFragmentByTag(currentFragmentTag)

        if (fragmentByTag != null){
            transaction.hide(fragmentByTag)
        }

        var attachFragment = supportFragmentManager.findFragmentByTag(fragmentClass?.simpleName)

        if (attachFragment == null){
            attachFragment = fragmentClass?.newInstance() as Fragment?
            transaction.add(R.id.content_layout, attachFragment, fragmentClass?.simpleName)
        }else{
            transaction.show(attachFragment)
        }
        transaction.commit()
        currentFragmentTag = fragmentClass?.simpleName


        if (v !== lastClickView){
            v.isSelect(true)
            if (lastClickView != null){
                lastClickView?.isSelect(false)
            }else{
                lastClickView = v
            }
        lastClickView = v
        }


    }

}
