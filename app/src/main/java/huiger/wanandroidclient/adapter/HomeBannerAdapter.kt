package huiger.wanandroidclient.adapter

import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import huiger.wanandroidclient.R
import huiger.wanandroidclient.bean.HomeListBean
import huiger.wanandroidclient.utils.CommonUtils
import huiger.wanandroidclient.utils.LinkClickableSpan


/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/23 16:37
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc : HomeBannerAdapter
 *
 ****************************************************************/
class HomeBannerAdapter(datas: MutableList<HomeListBean.DatasBean>) : BaseQuickAdapter<HomeListBean.DatasBean, BaseViewHolder>(R.layout.adapter_home_item_layout, datas) {

    override fun convert(helper: BaseViewHolder, item: HomeListBean.DatasBean?) {

        item ?: return

        helper.setText(R.id.tv_auther, item.author)
                .setText(R.id.tv_time, CommonUtils.dataForMat(item.publishTime))
                .setText(R.id.tv_title, item.title)
                .addOnClickListener(R.id.content_layout)
                .setChecked(R.id.cb_collect, item.isCollect)

        val superName = item.superChapterName
        val chapterName = item.chapterName

        val title = "$superName>>$chapterName>>"
        val ss = SpannableString(title)
        ss.setSpan(LinkClickableSpan(mContext, superName!!), 0, superName!!.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(LinkClickableSpan(mContext, chapterName!!), superName.length + 2, title.length - 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val tvClassify = helper.getView<TextView>(R.id.tv_classify)
        tvClassify.text = ss
        tvClassify.movementMethod = LinkMovementMethod.getInstance()

    }


}


