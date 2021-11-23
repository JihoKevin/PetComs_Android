package kevin.android.petcoms.network.api

import kevin.android.petcoms.fragments.mypage.model.TestModel
import kevin.android.petcoms.fragments.mypage.model.TestModelDto
import kevin.android.petcoms.fragments.record.model.CommentModel
import kevin.android.petcoms.models.PostModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {

    @GET("posts/1")
    suspend fun getPost(): Response<PostModel>

    @GET("users")
    suspend fun getTestModel(): Response<TestModelDto>

    @GET("1")
    suspend fun getPostTest(): Response<TestModel>

    @GET("comment/{diaryId}")
    suspend fun getComment(
        @Path("diaryId") diaryId: Long
    ): CommentModel

}