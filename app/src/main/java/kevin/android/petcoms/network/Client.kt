package kevin.android.petcoms.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client { // 백엔드 웹 서버와  retrofit을 사용 할 예정

    // const val BASE_URL = "https://jsonplaceholder.typicode.com/" // retrofit 통신을 확인하기 위한 Fake Api 사용. 임시 API
    // const val BASE_URL = "http://10.0.2.2:8080/" -> localhost로 통신 할 때는 이걸로 사용하세요~
    // const val BASE_URL = "http://10.0.2.2:8080/api/pets/" // 종현한테 받은 임시 API
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