package kevin.android.petcoms.network

import kevin.android.petcoms.fragments.mypage.model.MyDiary
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

//    @GET("2")
//    fun getMyDiaryData(): Call<MutableList<MyDiary>>

    @GET("2")
    suspend fun getMyDiaryData(): Response<MyDiary> {
        return Client.retrofitService.getMyDiaryData()
    }

}