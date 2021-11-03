package kevin.android.petcoms.fragments.diary.repository

import kevin.android.petcoms.network.NetworkApi
import javax.inject.Inject


class DiaryRepository @Inject constructor(private val api: NetworkApi)  {

    suspend fun getPost() = api.getPost()
}