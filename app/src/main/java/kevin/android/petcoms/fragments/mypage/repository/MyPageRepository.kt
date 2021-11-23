package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.fragments.mypage.model.TestModelDto
import kevin.android.petcoms.network.api.NetworkApi
import retrofit2.Response
import javax.inject.Inject

class MyPageRepository @Inject constructor(private val api: NetworkApi) {

    suspend fun getTestModel(): Response<TestModelDto> = api.getTestModel()

}
