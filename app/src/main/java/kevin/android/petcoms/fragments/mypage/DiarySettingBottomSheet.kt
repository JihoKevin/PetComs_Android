package kevin.android.petcoms.fragments.mypage

import android.content.Context
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import kevin.android.petcoms.R

class DiarySettingBottomSheet(context: Context): BottomSheetDialog(context) {

    init {
        val view: View = layoutInflater.inflate(R.layout.bottomsheet_diary_setting, null)
        setContentView(view)
        dismiss()
    }

}