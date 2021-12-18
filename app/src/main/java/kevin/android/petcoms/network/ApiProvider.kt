package kevin.android.petcoms.network

import com.facebook.stetho.okhttp3.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kevin.android.petcoms.network.api.MyPageApi
import kevin.android.petcoms.network.api.NetworkApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OkHttpClientWithoutAuthorization

@Module
@InstallIn(SingletonComponent::class)
object ApiProvider {

//    @Provides
//    @DefaultOkHttpClient
//    fun getOkHttpClient(addHeaderInterceptor: AddHeaderInterceptor): OkHttpClient =
//        OkHttpClient.Builder().apply {
//            //TimeOut 시간을 지정합니다.
//            readTimeout(60, TimeUnit.SECONDS)
//            connectTimeout(60, TimeUnit.SECONDS)
//            writeTimeout(5, TimeUnit.SECONDS)
//
//            val interceptor = HttpLoggingInterceptor().apply {
//                level = if (BuildConfig.DEBUG) {
//                    HttpLoggingInterceptor.Level.BODY
//                } else {
//                    HttpLoggingInterceptor.Level.NONE
//                }
//            }
//
//            // 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
//            addInterceptor(interceptor)
//            addNetworkInterceptor(StethoInterceptor())
//
//            // header 에 정보를 추가해 준다.
//            addInterceptor(addHeaderInterceptor)
//        }.build()

    @Provides
    @OkHttpClientWithoutAuthorization
    fun getOkHttpClientWithoutAuthorization(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }

            // 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
            addInterceptor(interceptor)
            addNetworkInterceptor(StethoInterceptor())
        }.build()
    }

    @Provides
    fun providePostTest(@OkHttpClientWithoutAuthorization okHttpClient: OkHttpClient): NetworkApi =
        Client.create(okHttpClient)

    @Provides
    fun provideUserId(@OkHttpClientWithoutAuthorization okHttpClient: OkHttpClient): MyPageApi =
        Client.create(okHttpClient)
}