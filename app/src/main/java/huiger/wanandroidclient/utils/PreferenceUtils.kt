package huiger.wanandroidclient.utils

import android.content.Context
import android.content.SharedPreferences
import huiger.wanandroidclient.constans.Constans
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/****************************************************************
 * *     *  * * * *     Created by huiGer
 * *     *  *           Time : 2018/4/20 15:25
 * * * * *  *   * *     Email: zhihuiemail@163.com
 * *     *  *     *     Blog : huiGer.top
 * *     *  * * * *     Desc : Preference管理
 ****************************************************************/
class PreferenceUtils<T>(private val name: String, private val default: T) : ReadWriteProperty<Any?, T> {

    companion object {
        lateinit var preferences: SharedPreferences
        fun setContext(context: Context) {
            preferences = context.getSharedPreferences(Constans.SHARE_NAME, Context.MODE_PRIVATE)
        }

        fun clean() {
            preferences.edit().clear().apply()
        }
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): T = findPreference(name, default)

    private fun <U> findPreference(name: String, default: U): U = with(preferences) {
        val res: Any = when (default) {
            is Float -> getFloat(name, default)
            is Int -> getInt(name, default)
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Boolean -> getBoolean(name, default)
            else -> throw IllegalArgumentException("This type can`t be saved into Preferences")
        }
        res as U
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = savePreference(name, value)

    private fun <U> savePreference(name: String, value: U) = with(preferences.edit()) {
        when (value) {
            is Float -> putFloat(name, value)
            is Int -> putInt(name, value)
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Boolean -> putBoolean(name, value)
            else -> throw IllegalArgumentException("This type can`t be saved into Preferences")
        }.apply()
    }


}