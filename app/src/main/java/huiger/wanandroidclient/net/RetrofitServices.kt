package huiger.wanandroidclient.net

import huiger.wanandroidclient.bean.HomeBannerBean
import huiger.wanandroidclient.bean.HomeListBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 16:24
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/

interface RetrofitServices {

    @GET("banner/json")
    fun getHomeBanner() : Observable<BaseResponse<List<HomeBannerBean>>>

    @GET("article/list/{page}/json")
    fun getHomeData(@Path("page")index: Int) : Observable<BaseResponse<HomeListBean>>

}