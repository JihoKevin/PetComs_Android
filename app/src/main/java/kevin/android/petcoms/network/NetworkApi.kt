package kevin.android.petcoms.network

import kevin.android.petcoms.fragments.mypage.model.TestModelDto
import kevin.android.petcoms.models.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {

//    @GET("1")
//    suspend fun getPost(): List<PostModel>

    @GET("posts/1")
    suspend fun getPost(): Response<PostModel>

    @GET("users")
    suspend fun getTestModel(): Response<TestModelDto>

}