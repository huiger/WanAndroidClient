package huiger.wanandroidclient.presenter

import huiger.wanandroidclient.base.BasePresenter
import huiger.wanandroidclient.base.BaseView
import huiger.wanandroidclient.bean.HomeBannerBean

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 14:10
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/
interface IHomeContract {


    interface HomePresenter : BasePresenter {

        fun getBannerData()

        fun getHomeData(page: Int)

    }


    interface HomeView : BaseView {

        fun loadBannerSuccess(data: List<HomeBannerBean>)
        fun loadBannerFail(e: Throwable)
    }


}