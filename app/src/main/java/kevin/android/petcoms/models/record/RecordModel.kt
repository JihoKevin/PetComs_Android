package kevin.android.petcoms.models.record

import de.hdodenhof.circleimageview.CircleImageView

data class RecordModel(
    val date: String,
    val time: String,
    val profImg: Int,
    val nickName: String,
    val location: String
)
