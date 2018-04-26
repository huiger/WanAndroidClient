package huiger.wanandroidclient.net

/****************************************************************
 *```
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/20 16:49
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *```
 ****************************************************************/
data class BaseResponse<T>(val data : T, val errorCode: Int, val errorMsg: String) {

}