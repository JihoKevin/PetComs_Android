package kevin.android.petcoms.fragments.mypage

data class MyDiary(
//    val DUserImg: Int,
//    val DUserNickname: String,
//    val DDate: String
    val userId: Long, //임의 데이터, POST와 같음
    val id: Long,
    val title: String,
    val body: String
)