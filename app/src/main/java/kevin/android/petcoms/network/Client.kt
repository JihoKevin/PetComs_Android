package kevin.android.petcoms.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client { // 백엔드 웹 서버와  retrofit을 사용 할 예정

    private const val BASE_URL = "http://jsonplaceholder.typicode.com/posts/" // retrofit 통신을 확인하기 위한 Fake Api 사용. 임시 API
    //private const val BASE_URL = "http://10.0.2.2:8080/" -> localhost로 통신 할 때는 이걸로 사용하세요~
//    private const val BASE_URL = "http://10.0.2.2:8080/api/pets/" // 종현한테 받은 임시 API

    val retrofitService: NetworkApi

    init{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val logger = OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(logger)
            .build()

        retrofitService = retrofit.create(NetworkApi::class.java)
    }

}