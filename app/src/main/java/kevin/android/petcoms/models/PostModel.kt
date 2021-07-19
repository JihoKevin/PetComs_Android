package kevin.android.petcoms.models


data class PostModel( // mvvm 구조 검증을 위한 샘플 데이터 클래스 입니다.
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)
