package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.model.TestModel
import kevin.android.petcoms.network.NetworkApi
import retrofit2.Response
import javax.inject.Inject

class MyPageRepository @Inject constructor(private val api: NetworkApi) {

    suspend fun getPostTest(): Response<TestModel> = api.getPostTest()

    suspend fun getMyPets(): List<MyPets> {

        val lists =
            listOf<MyPets>(
                MyPets(1, 11, "탄이", "탄이예요"),
                MyPets(2, 12, "똘이", "똘이예요"),
                MyPets(3, 13, "깨비", "깨비예요")
            )

        return lists
    }

}