package huiger.wanandroidclient.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import huiger.wanandroidclient.R
import huiger.wanandroidclient.adapter.HomeBannerAdapter
import huiger.wanandroidclient.base.BaseFragment
import huiger.wanandroidclient.bean.HomeBannerBean
import huiger.wanandroidclient.bean.HomeListBean
import huiger.wanandroidclient.presenter.HomePresenterImpl
import huiger.wanandroidclient.presenter.IHomeContract
import huiger.wanandroidclient.utils.CommonUtils
import huiger.wanandroidclient.utils.dp2px
import kotlinx.android.synthetic.main.fragment_index_layout.*
import java.util.*

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 9:16
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     blog : huiGer.top
 * *     *  * * * *     Desc : IndexFragment
 ****************************************************************/
class IndexFragment : BaseFragment(), IHomeContract.HomeView {

    private val imgs: MutableList<String> = mutableListOf()
    private val tests: MutableList<String> = mutableListOf()
    private val bannerLayout: BGABanner by lazy {
        LayoutInflater.from(activity).inflate(R.layout.home_head_layout, null) as BGABanner
    }

    private val mAdapter: HomeBannerAdapter by lazy {
        HomeBannerAdapter()
    }

    private val homePresenter: HomePresenterImpl by lazy {
        HomePresenterImpl(this)
    }


    override fun setLayoutResId(): Int = R.layout.fragment_index_layout

    override fun initData() {
        homePresenter.getBannerData()
        homePresenter.getHomeData(0)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        bannerLayout.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, activity.dp2px(200f))
        bannerLayout.setAdapter(bannerAdapter)
        mAdapter.setHeaderView(bannerLayout)
        recyclerView.adapter = mAdapter
        mAdapter.setNewData(Arrays.asList())
    }

    private val bannerAdapter: BGABanner.Adapter<ImageView, String> by lazy {
        BGABanner.Adapter<ImageView, String>({ banner, itemView, url, position ->
            CommonUtils.showImage(activity, url, itemView)
        })
    }

    override fun <T> loadSuccess(data: T) {
        val bean = data as HomeListBean
        mAdapter.setNewData(bean.datas)
    }

    override fun loadFail(e: Throwable) {
        Log.d("msg", "IndexFragment -> loadFail: " + e.message)
    }

    override fun loadBannerSuccess(list: List<HomeBannerBean>) {

        list.forEach { data ->
            imgs.add(data.imagePath)
            tests.add(data.title)
        }

        bannerLayout.setData(imgs, tests)

    }

    override fun loadBannerFail(e: Throwable) {
        Log.d("msg", "IndexFragment -> loadBannerFail: " + e.message)
    }

}