package huiger.wanandroidclient.net

import huiger.wanandroidclient.BuildConfig
import huiger.wanandroidclient.constans.Constans
import huiger.wanandroidclient.utils.PreferenceUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 14:34
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc :
 ****************************************************************/
class RetrofitHelper {

    private val CONNECT_TIMEOUT = 30L
    private val READ_TIMEOUT = 10L
    /**
     * login
     */
    private val SAVE_USER_LOGIN_KEY = "user/login"
    /**
     * register
     */
    private val SAVE_USER_REGISTER_KEY = "user/register"
    private val SET_COOKIE_KEY = "set-cookie"


    val retrofitServices : RetrofitServices = getService(Constans.BASE_URL, RetrofitServices::class.java)

    private fun <T> getService(url: String, service: Class<T>): T = create(url).create(service)

    private fun create(url: String): Retrofit {

        var okHttpClientBuild = OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor {
                    val request = it.request()
                    val response = it.proceed(request)
                    val requestUrl = request.url().toString()
                    val domain = request.url().host()
                    // set-cookie maybe has multi, login to save cookie
                    if ((requestUrl.contains(SAVE_USER_LOGIN_KEY)
                            || requestUrl.contains(SAVE_USER_REGISTER_KEY))
                            && !response.headers(SET_COOKIE_KEY).isEmpty()) {
                        val cookies = response.headers(SET_COOKIE_KEY)
                        val cookie = encodeCookie(cookies)
                        saveCookie(requestUrl, domain, cookie)
                    }
                    response
                }


        if(BuildConfig.DEBUG){
            var log = HttpLoggingInterceptor()
            log.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuild.addInterceptor(log)
        }

        return Retrofit.Builder()
                .client(okHttpClientBuild.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build()

    }

    /**
     * saveCookie
     */
    private fun saveCookie(requestUrl: String?, domain: String?, cookies: String) {
        requestUrl ?: return
        var spUrl: String by PreferenceUtils(requestUrl, cookies)
        @Suppress("UNUSED_VALUE")
        spUrl = cookies
        domain ?: return
        var spDomain: String by PreferenceUtils(domain, cookies)
        @Suppress("UNUSED_VALUE")
        spDomain = cookies
    }

    /**
     * encodeCookie
     */
    private fun encodeCookie(cookies: List<String>): String {

        val sb = StringBuilder()
        val set = HashSet<String>()

        cookies.map { cookie ->
            cookie.split(";".toRegex()).dropLastWhile {
                it.isEmpty()
            }.toTypedArray()
        }.forEach {
            it.filter {
                set.contains(it)
            }.forEach {
                set.add(it)
            }
        }

        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        // c查找最后一个;
        val lastIndex = sb.lastIndexOf(";")
        if (sb.length - 1 == lastIndex) {
            // 删除最后一个;
            sb.deleteCharAt(lastIndex)
        }

        return sb.toString()
    }


}