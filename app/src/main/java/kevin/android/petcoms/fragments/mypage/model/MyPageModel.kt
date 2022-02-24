package kevin.android.petcoms.fragments.mypage.model

import okhttp3.MultipartBody

enum class UserStatus {
    NORMAL,
    REST,
    SUSPENDED
}

enum class Sex {
    F,
    M
}

//내 계정정보 조회 API H1
data class MyAccountModel(
    val status: Int,
    val responseMessage: String,
    val response: MyAccount
)

data class MyAccount(
    val status: UserStatus,
    val name: String,
    val email: String,
    val password: String,
    val nickname: String,
    val introduction: String,
    val imageUrl: String?,
    val createdAt: String,
    val modifiedAt: String,
    val dogsName: List<String>
)

//읽지 않은 알림 개수 조회 API H2
data class GetAlarmCountModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

//알림 목록 조회 API H3
data class GetShowAlarmListModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetShowAlarmList>
)

data class GetShowAlarmList(
    val diaryId: Long,
    val imageurl: String,
    val nickname: String,
    val message: String,
    val createdAt: String
)

//강아지 등록 API H4
data class PostMyPetModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

data class PostMyPet(
    val name: String,
    val breedId: Int,
    val birthday: String,
    val weight: Float,
    val sex: Sex,
    val age: Int,
    val isNeutered: Int
)

//강아지별 프로필 조회 API H5
//data class GetDogProfileModel(
//    val status: Int,
//    val responseMessage: String,
//    val response: List<GetDogProfile>
//)
//
//data class GetDogProfile(
//    val imageurl: String,
//    val birthday: String,
//    val weight: Float,
//    val sex: Sex,
//    val name: String,
//    val breed: String,
//    val age: Int
//)

//내 핀 목록 조회 API H6
data class GetMyPinModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetMyPin>
)

data class GetMyPin(
    val nickname: String,
    val profileImageUrl: String,
    val text: String,
    val contentImageUrl: String
)

//내 가족 목록 조회 API H7
data class GetFamilyModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetFamily>
)

data class GetFamily(
    val id: Long,
    val name: String,
    val imageUrl: String
)

//프로필 이미지 업로드 API H10
data class UploadProfileImageModel(
    val status: Int,
    val responseMessage: String,
    val response: String
)

data class UploadProfileImage(
    val profileImage: MultipartBody.Part
)

//강아지별 다이어리 조회 API D1
data class GetMyDiaryModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetMyDiary>
)

data class GetMyDiary(
    val creatAt: String,
    val text: String,
    val commentCount: Int,
    val pinCount: Int,
    val diaryId: Long
)

//다이어리 작성 API D2
data class PostDiaryModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

data class PostDiary(
    val userId: Long,
    val dogId: Long,
    val howManyDogs: Int,
    val isPublic: Int,
    val text: String,
    val imageUrl: String,
    val address: String,
    val locationName: String,
    val x: String,
    val y: String
)

//다이어리 수정 API D3
data class PutDiaryModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

data class PutDiary(
    val howManyDogs: Int,
    val isPublic: Int,
    val text: String
)

//다이어리 삭제 API D4
data class DeleteDiaryModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

//다이어리 공유 설정 변경 API D5
data class ChangePrivateModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

//다이어리 댓글 상세보기 API D6
data class GetCommentModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetComment>
)

data class GetComment(
    val nickname: String,
    val imageurl: String?,
    val text: String,
    val aftertime: String,
    val commentCommentId: String
)

//다이어리 핀한수 상세보기 API D7
data class GetPinCountModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetPinCount>
)

data class GetPinCount(
    val imageurl: String,
    val nickName: String
)

//다이어리 댓글 작성 API D8
data class PostCommentModel(
    val status: Int,
    val responseMessage: String,
    val response: Int
)

data class PostComment(
    val userId: Long,
    val diaryId: Long,
    val text: String,
    val commentComment: Long,
)