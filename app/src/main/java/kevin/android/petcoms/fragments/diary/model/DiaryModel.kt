package kevin.android.petcoms.fragments.diary.model

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
