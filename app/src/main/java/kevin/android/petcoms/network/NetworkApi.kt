package kevin.android.petcoms.network

import kevin.android.petcoms.models.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {

//    @GET("1")
//    suspend fun getPost(): List<PostModel>

    @GET("1")
    suspend fun getPost(): Response<PostModel> {
        return Client.retrofitService.getPost()
    }

    @GET("2")
    suspend fun getPost2(): Response<PostModel> {
        return Client.retrofitService.getPost2()
    }

}