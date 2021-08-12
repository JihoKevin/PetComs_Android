package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.models.PostModel
import kevin.android.petcoms.network.Client
import retrofit2.Response

class MyPageRepository {

    suspend fun getPost2(): Response<PostModel> {
        return Client.retrofitService.getPost2()
    }

}