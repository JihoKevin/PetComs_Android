package kevin.android.petcoms.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client { // 백엔드 웹 서버와  retrofit을 사용 할 예정

    const val BASE_URL = "http://ec2-3-37-206-169.ap-northeast-2.compute.amazonaws.com:8081/"

    fun <T> create(service: Class<T>, client: OkHttpClient, httpUrl: String = BASE_URL): T =
        Retrofit.Builder()
            .baseUrl(httpUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service)

    inline fun <reified T : Any> create(client: OkHttpClient, httpUrl: String = BASE_URL): T {
        require(httpUrl.isNotBlank()) { "Parameter httpUrl cannot be blank." }
        return create(service = T::class.java, httpUrl = httpUrl, client = client)
    }

}