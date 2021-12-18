package kevin.android.petcoms

import android.content.Context
import android.content.SharedPreferences

object PrefUtil {

    private const val PREF_NAME = "Pref"

    private lateinit var pref: SharedPreferences

    const val PREF_ACCESS_TOKEN = "access_token"

    const val PREF_REFRESH_TOKEN = "refresh_token"

    const val PREF_USER_MEMBERSHIP = "user_membership"

    const val PREF_USER_ID = "user_id"
    const val PREF_USER_NAME = "user_name"
    const val PREF_USER_EMAIL = "user_email"
    const val PREF_USER_PHONE = "user_phone"
    const val PREF_USER_ADDRESS = "user_address"
    const val PREF_USER_POSTCODE = "user_postcode"

    const val PREF_IS_SHOW_TUTORIAL = "is_show_tutorial"
    const val PREF_IS_GENERAL_SIGN_IN = "is_general_sign_in"

    @JvmStatic
    fun init(context: Context) {
        pref = context.applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @JvmStatic
    fun get(key: String, defValue: String): String {
        return pref.getString(key, defValue) ?: defValue
    }

    @JvmStatic
    fun get(key: String, defValue: Int): Int {
        return pref.getInt(key, defValue)
    }

    @JvmStatic
    fun get(key: String, defValue: Long): Long {
        return pref.getLong(key, defValue)
    }

    @JvmStatic
    fun get(key: String, defValue: Boolean): Boolean {
        return pref.getBoolean(key, defValue)
    }

    @JvmStatic
    fun put(key: String, value: String) {
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    @JvmStatic
    fun put(key: String, value: Int) {
        val editor = pref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    @JvmStatic
    fun put(key: String, value: Long) {
        val editor = pref.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    @JvmStatic
    fun put(key: String, value: Boolean) {
        val editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    @JvmStatic
    fun remove(key: String) {
        val editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }

    @JvmStatic
    fun clear() {
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }
}