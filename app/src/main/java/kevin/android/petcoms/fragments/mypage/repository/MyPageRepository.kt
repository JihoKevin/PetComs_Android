package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.fragments.mypage.model.MyAccount
import kevin.android.petcoms.fragments.mypage.model.MyAccountModel
import kevin.android.petcoms.fragments.mypage.model.TestModelDto
import kevin.android.petcoms.network.api.MyPageApi
import kevin.android.petcoms.network.api.NetworkApi
import retrofit2.Response
import javax.inject.Inject

class MyPageRepository @Inject constructor(private val api: MyPageApi) {

    suspend fun getUserId(userId: Long) = api.getUserId(userId)

    suspend fun postMyPet(userId: Long) = api.postMyPet(userId)

    suspend fun getMyPin(userId: Long) = api.getMyPin(userId)

    suspend fun getMyFamily(userId: Long) = api.getMyFamily(userId)

    suspend fun getDogID(dogID: Long) = api.getDogID(dogID)

    suspend fun postDiary() = api.postDiary()

    suspend fun putDairy(diaryId: Long) = api.putDairy(diaryId)

    suspend fun deleteDiary(diaryId: Long) = api.deleteDiary(diaryId)

    suspend fun getComment(diaryId: Long) = api.getComment(diaryId)

    suspend fun postComment() = api.postComment()

}
