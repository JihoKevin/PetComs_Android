package kevin.android.petcoms.network

import kevin.android.petcoms.models.PostModel
import retrofit2.http.GET

interface NetworkApi {

    @GET("1")
    suspend fun getPost(): List<PostModel>
}