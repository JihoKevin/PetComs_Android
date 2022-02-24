package kevin.android.petcoms.network.api

import kevin.android.petcoms.fragments.mypage.model.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface MyPageApi {

    @GET("account/{userId}") //H1
    suspend fun getUserId(@Path("userId") userId: Long): MyAccountModel

    @GET("alarm/count/{userId}") //H2
    suspend fun getAlarmCount(@Path("userId") userId: Long): GetAlarmCountModel

    @GET("alarm/list/{userId}") //H3
    suspend fun getShowAlarmList(@Path("userId") userId: Long): Response<GetShowAlarmListModel>

    @POST("dog/{userId}")
    suspend fun postMyPet(@Path("userId") userId: Long, @Body postMyPet: PostMyPet): PostMyPetModel

//    @GET("dog/profile/{nickName}/{dogName}") //H5
//    suspend fun getDogProfile(
//        @Path("nickName") nickName: String,
//        @Path("dogName") dogName: String
//    ): GetDogProfileModel

    @GET("list/pin/{userId}")
    suspend fun getMyPin(@Path("userId") userId: Long): Response<GetMyPinModel>

    @GET("family/{userId}")
    suspend fun getMyFamily(@Path("userId") userId: Long): Response<GetFamilyModel>

    @Multipart
    @POST("s3/upload/img/profile/{userId}")
    suspend fun uploadProfileImage(
        @Path("userId") userId: Long,
        @Part profileImage: MultipartBody.Part?): UploadProfileImageModel

    @GET("diary/{userId}/{nickName}/{dogName}")
    suspend fun getMyDiary(
        @Path("userId") userId: Long,
        @Path("nickName") nickName: String,
        @Path("dogName") dogName: String
    ): Response<GetMyDiaryModel>

    @POST("diary")
    suspend fun postDiary(@Body postDiary: PostDiary): PostDiaryModel

    @PATCH("diary/{diaryId}")
    suspend fun putDiary(@Path("diaryId") diaryId: Long, @Body putDiary: PutDiary): PutDiaryModel

    @DELETE("diary/{diaryId}")
    suspend fun deleteDiary(@Path("diaryId") diaryId: Long): DeleteDiaryModel

    @PUT("diary/toggle/{diaryId}") //D5
    suspend fun changePrivate(@Path("diaryId") diaryId: Long): ChangePrivateModel

    @GET("comment/{diaryId}")
    suspend fun getComment(@Path("diaryId") diaryId: Long): Response<GetCommentModel>

    @GET("pin/diary/{diaryId}")
    suspend fun getPinCount(@Path("diaryId") diaryId: Long): Response<GetPinCountModel>

    @POST("comment") //D8
    suspend fun postComment(@Body postComment: PostComment): PostCommentModel

}