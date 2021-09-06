package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.network.Client
import retrofit2.Response

class MyPageRepository {

    suspend fun getMyDiaryData(): Response<MyDiary> {
        return Client.retrofitService.getMyDiaryData()
    }

}