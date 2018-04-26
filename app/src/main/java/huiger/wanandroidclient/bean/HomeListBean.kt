package huiger.wanandroidclient.bean

/****************************************************************
 *
 *      *     *  * * * *     Created by huiGer
 *      *     *  *           Time : 2018/4/23 16:53
 *      * * * *  *   * *     Email: zhihuiemail@163.com
 *      *     *  *     *     Blog : huiGer.top
 *      *     *  * * * *     Desc :
 *
 ****************************************************************/

class HomeListBean {

    var curPage: Int = 0
    var offset: Int = 0
    var isOver: Boolean = false
    var pageCount: Int = 0
    var size: Int = 0
    var total: Int = 0
    var datas: List<DatasBean>? = null

    class DatasBean {
        /**
         * apkLink :
         * author : zfman
         * chapterId : 357
         * chapterName : 表格类
         * collect : false
         * courseId : 13
         * desc : 一个功能完善、UI简洁的仿超级课程表的课表控件(目前只维护Android Studio版本)
         *
         *
         * envelopePic : http://www.wanandroid.com/blogimgs/d55b4ca3-9486-4b53-abfb-d5f4fcf76d6b.png
         * fresh : true
         * id : 2868
         * link : http://www.wanandroid.com/blog/show/2117
         * niceDate : 2小时前
         * origin :
         * projectLink : https://github.com/zfman/TimetableView
         * publishTime : 1524463250000
         * superChapterId : 294
         * superChapterName : 开源项目主Tab
         * tags : [{"name":"项目","url":"/project/list/1?cid=357"}]
         * title : 一个功能完善、UI简洁的仿超级课程表的课表控件 TimetableView
         * type : 0
         * visible : 1
         * zan : 0
         */

        var apkLink: String? = null
        var author: String? = null
        var chapterId: Int = 0
        var chapterName: String? = null
        var isCollect: Boolean = false
        var courseId: Int = 0
        var desc: String? = null
        var envelopePic: String? = null
        var isFresh: Boolean = false
        var id: Int = 0
        var link: String? = null
        var niceDate: String? = null
        var origin: String? = null
        var projectLink: String? = null
        var publishTime: Long = 0
        var superChapterId: Int = 0
        var superChapterName: String? = null
        var title: String? = null
        var type: Int = 0
        var visible: Int = 0
        var zan: Int = 0
        var tags: List<TagsBean>? = null

        class TagsBean {
            /**
             * name : 项目
             * url : /project/list/1?cid=357
             */

            var name: String? = null
            var url: String? = null
        }
    }
}
