package kevin.android.petcoms.fragments.diary.repository

import kevin.android.petcoms.network.api.DiaryApi
import javax.inject.Inject

class DiaryRepository @Inject constructor(private val api: DiaryApi)  {

    suspend fun getAllDiary(sorted: String) = api.getAllDiary(sorted) //S1

    suspend fun getUserProfile(userName: String) = api.getUserProfile(userName) //S9

    suspend fun getDogProfile(nickName: String, dogName: String) = api.getDogProfile(nickName, dogName) //강아지별 프로필 조회 API H5

}