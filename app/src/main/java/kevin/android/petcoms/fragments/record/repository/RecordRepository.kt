package kevin.android.petcoms.fragments.record.repository

import kevin.android.petcoms.models.PostModel
import kevin.android.petcoms.network.Client
import kevin.android.petcoms.network.NetworkApi
import retrofit2.Response
import javax.inject.Inject

class RecordRepository @Inject constructor(private val api: NetworkApi) {

    suspend fun getPost(): Response<PostModel>{
        return api.getPost()
    }





}