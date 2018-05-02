package huiger.wanandroidclient.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import cn.bingoogolapple.bgabanner.BGABanner
import com.chad.library.adapter.base.BaseQuickAdapter
import huiger.wanandroidclient.R
import huiger.wanandroidclient.adapter.HomeBannerAdapter
import huiger.wanandroidclient.base.BaseFragment
import huiger.wanandroidclient.bean.HomeBannerBean
import huiger.wanandroidclient.bean.HomeListBean
import huiger.wanandroidclient.constans.Constans
import huiger.wanandroidclient.presenter.HomePresenterImpl
import huiger.wanandroidclient.presenter.IHomeContract
import huiger.wanandroidclient.ui.activity.WebActivity
import huiger.wanandroidclient.utils.CommonUtils
import huiger.wanandroidclient.utils.dp2px
import huiger.wanandroidclient.utils.toast
import kotlinx.android.synthetic.main.fragment_index_layout.*

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
    private val mDatas = mutableListOf<HomeListBean.DatasBean>()

    private val bannerLayout: BGABanner by lazy {
        LayoutInflater.from(activity).inflate(R.layout.home_head_layout, null) as BGABanner
    }

    private val mAdapter: HomeBannerAdapter by lazy {
        HomeBannerAdapter(mDatas)
    }

    private val homePresenter: HomePresenterImpl by lazy {
        HomePresenterImpl(this)
    }


    override fun setLayoutResId(): Int = R.layout.fragment_index_layout

    override fun initData() {
        homePresenter.getBannerData()
        homePresenter.getHomeData(0)

        recyclerView.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }

        mAdapter.run {
            bindToRecyclerView(recyclerView)
            addHeaderView(bannerLayout)
            setOnItemChildClickListener(itemChildClickListener)
        }


        bannerLayout.run {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, activity.dp2px(200f))
            setAdapter(bannerAdapter)
        }


    }

    private val itemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { _, _, position ->
        if (mDatas.size != 0) {
            Intent(activity, WebActivity::class.java).run {
                putExtra(Constans.JUMP_URL, mDatas[position].link)

                startActivity(this)
            }
        }
    }

    private val bannerAdapter: BGABanner.Adapter<ImageView, String> by lazy {
        BGABanner.Adapter<ImageView, String>({ banner, itemView, url, position ->
            CommonUtils.showImage(activity, url, itemView)
        })
    }

    override fun <T> loadSuccess(data: T) {
        val bean = data as HomeListBean
        bean.datas?.let {
            mAdapter.run {


                addData(it)
            }
        }
    }

    override fun loadFail(e: Throwable) {
        toast(e.message.toString())
    }

    override fun loadBannerSuccess(list: List<HomeBannerBean>) {

        list.forEach { data ->
            imgs.add(data.imagePath)
            tests.add(data.title)
        }

        bannerLayout.setData(imgs, tests)

    }

    override fun loadBannerFail(e: Throwable) {
        toast(e.message.toString())
    }

}