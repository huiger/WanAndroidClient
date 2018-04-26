package huiger.wanandroidclient.presenter

import huiger.wanandroidclient.net.RetrofitHelper
import huiger.wanandroidclient.utils.io_main

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 14:20
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/
class HomePresenterImpl(view: IHomeContract.HomeView) : IHomeContract.HomePresenter {
    var mView: IHomeContract.HomeView? = null

    init {
        mView = view
    }


    override fun onNetwork() {


    }

    override fun getHomeData(page: Int) {
        RetrofitHelper().retrofitServices
                .getHomeData(page)
                .io_main()
                ?.subscribe({homeData ->
                    mView?.loadSuccess(homeData)
                }, {
                    e -> mView?.loadFail(e)
                })
    }

    override fun onDestroy() {
        mView?.let { mView = null }
    }

    override fun getBannerData() {
        RetrofitHelper().retrofitServices
                .getHomeBanner()
                .io_main()
                ?.subscribe({ bannerData ->
                    mView?.loadBannerSuccess(bannerData)
                }, {
                    e -> mView?.loadBannerFail(e)
                })


    }


}

