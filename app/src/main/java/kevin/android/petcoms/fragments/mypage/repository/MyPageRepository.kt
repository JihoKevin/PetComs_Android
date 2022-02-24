package kevin.android.petcoms.fragments.mypage.repository

import kevin.android.petcoms.fragments.mypage.model.*
import kevin.android.petcoms.network.api.MyPageApi
import okhttp3.MultipartBody
import javax.inject.Inject

class MyPageRepository @Inject constructor(private val api: MyPageApi) {

    suspend fun getUserId(userId: Long) = api.getUserId(userId) //내 계정정보 조회 API H1

    suspend fun getAlarmCount(userId: Long) = api.getAlarmCount(userId) //읽지 않은 알림 개수 조회 API H2

    suspend fun getShowAlarmList(userId: Long) = api.getShowAlarmList(userId) //알림 목록 조회 API H3

    suspend fun postMyPet(userId: Long, postMyPet: PostMyPet) = api.postMyPet(userId, postMyPet) //강아지 등록 API H4

//    suspend fun getDogProfile(nickName: String, dogName: String) = api.getDogProfile(nickName, dogName) //강아지별 프로필 조회 API H5

    suspend fun getMyPin(userId: Long) = api.getMyPin(userId) //내 핀 목록 조회 API H6

    suspend fun getMyFamily(userId: Long) = api.getMyFamily(userId) //내 가족 목록 조회 API H7

    suspend fun uploadProfileImage(userId: Long, profileImage: MultipartBody.Part?) = api.uploadProfileImage(userId, profileImage) //프로필 이미지 업로드 API H10

    suspend fun getMyDiary(userId: Long, nickName: String, dogName: String) = api.getMyDiary(userId, nickName, dogName) //강아지별 다이어리 조회 API D1

    suspend fun postDiary(postDiary: PostDiary) = api.postDiary(postDiary) //다이어리 작성 API D2

    suspend fun putDiary(diaryId: Long, putDiary: PutDiary) = api.putDiary(diaryId, putDiary) //다이어리 수정 API D3

    suspend fun deleteDiary(diaryId: Long) = api.deleteDiary(diaryId) //다이어리 삭제 API D4

    suspend fun changePrivate(diaryId: Long) = api.changePrivate(diaryId) //다이어리 공유 설정 변경 API D5

    suspend fun getComment(diaryId: Long) = api.getComment(diaryId) //다이어리 댓글 상세보기 API D6

    suspend fun getPinCount(diaryId: Long) = api.getPinCount(diaryId) //다이어리 핀한수 상세보기 API D7

    suspend fun postComment(postComment: PostComment) = api.postComment(postComment) //다이어리 댓글 작성 API D8

}
