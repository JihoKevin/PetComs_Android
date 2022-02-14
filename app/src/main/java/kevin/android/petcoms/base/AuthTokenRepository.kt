package kevin.android.petcoms.base

import kevin.android.petcoms.network.api.AuthTokenApi
import javax.inject.Inject

class AuthTokenRepository @Inject constructor(private val service: AuthTokenApi) {

    fun refreshToken(refreshToken: String): String =
        service.refreshToken(refreshToken)
}