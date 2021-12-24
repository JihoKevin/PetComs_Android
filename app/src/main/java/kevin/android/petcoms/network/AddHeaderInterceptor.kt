package kevin.android.petcoms.network

import android.util.Log
import kevin.android.petcoms.AuthTokenRepository
import kevin.android.petcoms.PrefUtil
import okhttp3.Interceptor
import okhttp3.Response

// https://github.com/square/okhttp/wiki/Interceptors
class AddHeaderInterceptor(private val authTokenRepository: AuthTokenRepository) {

//    companion object {
//        private const val TAG = "AddHeaderInterceptor"
//    }
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val token = PrefUtil.get(PrefUtil.PREF_ACCESS_TOKEN, "")
//
//        val builder = chain.request().newBuilder()
//        if (token.isNotBlank()) {
//            builder.addHeader("token", token)
//        }
//        val response = chain.proceed(builder.build())
//
//        try {
//            if (response.code == 401) {
//                val refreshToken = PrefUtil.get(PrefUtil.PREF_REFRESH_TOKEN, "")
//                val freshToken = authTokenRepository.refreshToken(refreshToken)
//                    .blockingGet()
//                if (!freshToken.isNullOrBlank()) {
//                    PrefUtil.put(PrefUtil.PREF_ACCESS_TOKEN, freshToken)
//                    response.close()
//                    val request =
//                        chain.request().newBuilder().addHeader("token", freshToken).build()
//                    Log.d("kevin", "successfully refresh token: $refreshToken")
//                    return chain.proceed(request)
//                } else {
//                    Log.d("kevin", "failed to refresh token: $token")
//
//                }
//            }
//        } catch (e: Throwable) {
//            Log.e(TAG, "refresh token failed", e)
//        }
//
//        return response
//    }
}