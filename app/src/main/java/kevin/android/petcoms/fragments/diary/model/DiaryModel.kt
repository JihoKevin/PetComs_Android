package kevin.android.petcoms.fragments.diary.model

import kevin.android.petcoms.fragments.mypage.model.Sex

// S1
data class GetAllDiaryModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetAllDiary>
)

data class GetAllDiary(
    val text: String,
    val id: Long,
    val userId: Long,
    val howManyComments: Int,
    val imageUrl: String,
    val registeredAt: String,
    val howManyPins: Int,
    val isPublic: Int,
    val locationName: String,
    val nickName: String,
    val userImageUrl: String
)

//S9
data class GetUserProfileModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetUserProfile>
)

data class GetUserProfile(
    val introduction: String,
    val badge: String,
    val nickName: String,
    val imagUrl: String
)

//강아지별 프로필 조회 API H5
data class GetDogProfileModel(
    val status: Int,
    val responseMessage: String,
    val response: List<GetDogProfile>
)

data class GetDogProfile(
    val imageurl: String,
    val birthday: String,
    val weight: Float,
    val sex: Sex,
    val name: String,
    val breed: String,
    val age: Int
)
