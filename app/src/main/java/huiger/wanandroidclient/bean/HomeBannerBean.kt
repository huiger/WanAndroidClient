package huiger.wanandroidclient.bean

/****************************************************************
 *```
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/20 16:53
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *```
 ****************************************************************/
data class HomeBannerBean(
        val id: Int,
        val desc: String,
        val imagePath : String,
        val isVisible : Int,
        val order : Int,
        val title : String,
        val type : Int,
        val url : String
)