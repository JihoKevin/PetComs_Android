package kevin.android.petcoms.network.api

import kevin.android.petcoms.fragments.mypage.model.MyAccountModel
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthTokenApi {

    @GET("account/{userId}")
    suspend fun getRefreshToken(@Path("userId") userId: Long): MyAccountModel

}