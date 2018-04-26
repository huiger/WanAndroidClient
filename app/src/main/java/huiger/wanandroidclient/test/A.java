package huiger.wanandroidclient.test;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import cn.bingoogolapple.bgabanner.BGABanner;

/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/23 14:29
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *
 ****************************************************************/

public class A {

    public void t(){

    }

    BGABanner.Adapter<ImageView, String> adapter = new BGABanner.Adapter<ImageView, String>() {
        @Override
        public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
            Log.d("msg", "A -> fillBannerItem: " + model);
        }
    };

}
