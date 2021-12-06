package kevin.android.petcoms.network.api

import kevin.android.petcoms.fragments.mypage.model.*
import kevin.android.petcoms.fragments.record.model.CommentModel
import retrofit2.Response
import retrofit2.http.*

interface MyPageApi {

    @GET("account/{userId}")
    suspend fun getUserId(@Path("userId") userId: Long): MyAccountModel

    @POST("dog/{userId}")
    suspend fun postMyPet(@Path("userId") userId: Long): PostMyPetModel

    @GET("diary/list/pin/{userId}")
    suspend fun getMyPin(@Path("userId") userId: Long): GetMyPinModel

    @GET("dog/{userId}")
    suspend fun getMyFamily(@Path("userId") userId: Long): GetFamilyModel

    @GET("diary/{dogID}")
    suspend fun getDogID(@Path("dogID") dogID: Long): MyDiaryModel

    @POST("diary")
    suspend fun postDiary(): PostDiaryModel

    @PUT("diary/{diaryId}")
    suspend fun putDairy(@Path("diaryId") diaryId: Long): PutDiaryModel

    @DELETE("diary/{diaryId}")
    suspend fun deleteDiary(@Path("diaryId") diaryId: Long): DeleteDiaryModel

    @GET("comment/{diaryId}")
    suspend fun getComment(@Path("diaryId") diaryId: Long): CommentModel

    @POST("comment")
    suspend fun postComment(): PostCommentModel

}