package kevin.android.petcoms.fragments.record.model

data class CommentModel(
    val status: Int,
    val responseMessage: String,
    val response: List<Comments>
)

data class Comments (
    val nickname: String,
    val imageurl: String?,
    val text: String,
    val aftertime: String,
    val commentCommentId: String
)
