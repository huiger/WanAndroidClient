package huiger.wanandroidclient.adapter

import android.widget.CheckBox
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import huiger.wanandroidclient.R
import huiger.wanandroidclient.bean.HomeListBean
import huiger.wanandroidclient.utils.CommonUtils


/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/23 16:37
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc : HomeBannerAdapter
 *
 ****************************************************************/
class HomeBannerAdapter : BaseQuickAdapter<HomeListBean.DatasBean, BaseViewHolder>(R.layout.adapter_home_item_layout) {

    override fun convert(helper: BaseViewHolder, item: HomeListBean.DatasBean) {
        helper.getView<TextView>(R.id.tv_auther).text = item.author
        helper.getView<TextView>(R.id.tv_time).text = CommonUtils().dataForMat(item.publishTime)
        helper.getView<TextView>(R.id.tv_title).text = item.title

        helper.getView<CheckBox>(R.id.cb_collect).isChecked = item.isCollect
    }

}



