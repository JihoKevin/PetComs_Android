package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.fragments.mypage.MyDiary
import kevin.android.petcoms.models.PostModel
import kevin.android.petcoms.network.Client
import kevin.android.petcoms.network.NetworkApi
import retrofit2.Response
import retrofit2.Retrofit

class MyPageRepository {

    suspend fun getMyDiaryData(): Response<MyDiary> {
        return Client.retrofitService.getMyDiaryData()
    }

}