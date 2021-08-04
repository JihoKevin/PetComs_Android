package kevin.android.petcoms.fragments.record.repository

import kevin.android.petcoms.models.PostModel
import kevin.android.petcoms.network.Client
import retrofit2.Response

class RecordRepository {

    suspend fun getPost(): Response<PostModel>{
        return Client.retrofitService.getPost()
    }



}