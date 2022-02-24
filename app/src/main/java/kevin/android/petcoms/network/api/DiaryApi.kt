package kevin.android.petcoms.network.api

import kevin.android.petcoms.fragments.diary.model.GetAllDiaryModel
import kevin.android.petcoms.fragments.diary.model.GetDogProfileModel
import kevin.android.petcoms.fragments.diary.model.GetUserProfileModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DiaryApi {

    @GET("diary/{sorted}") //S1
    suspend fun getAllDiary(@Path("sorted") sorted: String): Response<GetAllDiaryModel>

    @GET("profile/{userName}") //S9
    suspend fun getUserProfile(@Path("userName") userName: String): GetUserProfileModel

    @GET("dog/profile/{nickName}/{dogName}") //H5
    suspend fun getDogProfile(
        @Path("nickName") nickName: String,
        @Path("dogName") dogName: String
    ): GetDogProfileModel

}