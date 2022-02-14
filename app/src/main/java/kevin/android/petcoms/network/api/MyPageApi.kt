package kevin.android.petcoms.network.api

import kevin.android.petcoms.fragments.mypage.model.*
import retrofit2.Response
import retrofit2.http.*

interface MyPageApi {

    @GET("account/{userId}") //H1
    suspend fun getUserId(@Path("userId") userId: Long): MyAccountModel

    @GET("alarm/count/{userId}") //H2
    suspend fun getAlarmCount(@Path("userId") userId: Long): GetAlarmCountModel

    @POST("dog/{userId}")
    suspend fun postMyPet(@Path("userId") userId: Long, @Body postMyPet: PostMyPet): PostMyPetModel

    @GET("list/pin/{userId}")
    suspend fun getMyPin(@Path("userId") userId: Long): GetMyPinModel

    @GET("family/{userId}")
    suspend fun getMyFamily(@Path("userId") userId: Long): Response<GetFamilyModel>

    @GET("diary/{userId}/{nickName}/{dogName}")
    suspend fun getMyDiary(
        @Path("userId") userId: Long,
        @Path("nickName") nickName: String,
        @Path("dogName") dogName: String): Response<GetMyDiaryModel>

    @POST("diary")
    suspend fun postDiary(@Body postDiary: PostDiary): PostDiaryModel

    @PUT("diary/{diaryId}")
    suspend fun putDiary(@Path("diaryId") diaryId: Long, @Body putDiary: PutDiary): PutDiaryModel

    @DELETE("diary/{diaryId}")
    suspend fun deleteDiary(@Path("diaryId") diaryId: Long): DeleteDiaryModel

    @GET("comment/{diaryId}")
    suspend fun getComment(@Path("diaryId") diaryId: Long): Response<GetCommentModel>

    @GET("pin/diary/{diaryId}")
    suspend fun getPinCount(@Path("diaryId") diaryId: Long): GetPinCountModel

    @POST("comment") //D8
    suspend fun postComment(@Body postComment: PostComment): PostCommentModel

}