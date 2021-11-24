package kevin.android.petcoms.fragments.record.repository

import kevin.android.petcoms.network.api.NetworkApi
import javax.inject.Inject

class RecordRepository @Inject constructor(private val api: NetworkApi) {

    suspend fun getComment(diaryId: Long) = api.getComment(diaryId)






}