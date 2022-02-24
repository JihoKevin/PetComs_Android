package kevin.android.petcoms.fragments.mypage
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.Observer
//import com.bumptech.glide.Glide
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//import kevin.android.petcoms.R
//import kevin.android.petcoms.databinding.BottomsheetDiarySettingBinding
//import kevin.android.petcoms.fragments.mypage.model.ChangePrivateModel
//import kevin.android.petcoms.fragments.mypage.model.DeleteDiaryModel
//import kevin.android.petcoms.fragments.mypage.model.PutDiary
//import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
//import kotlinx.android.synthetic.main.bottomsheet_diary_setting.*
//
//class DiarySettingBottomSheet: BottomSheetDialogFragment() {
//
//    private var bottomSheetDiarySettingBinding: BottomsheetDiarySettingBinding? = null
//    private val viewModel: MyPageViewModel by activityViewModels()
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//
//        val binding = BottomsheetDiarySettingBinding.inflate(inflater, container, false)
//        bottomSheetDiarySettingBinding = binding
//
//        bottomSheetDiarySettingBinding!!.editDiary.setOnClickListener {
//            val updateDiary = UpdateDiary()
//            val transaction= fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.diarySettingBottomSheet, updateDiary)?.commit()
//        }
//
//        bottomSheetDiarySettingBinding!!.deleteDiary.setOnClickListener {
//            viewModel.deleteDiary(diaryid)
//        }
//
////        bottomSheetDiarySettingBinding!!.changePrivate.setOnClickListener {
////
////            viewModel.changePrivate.observe(viewLifecycleOwner, Observer {
////                if (it.response == 1) {
////                    Toast.makeText(context, "다이어리가 공개로 전환되었습니다.", Toast.LENGTH_SHORT).show()
////                } else {
////                    Toast.makeText(context, "다이어리가 비공개로 전환되었습니다.", Toast.LENGTH_SHORT).show()
////                }
////            })
////
////        }
//
//        return bottomSheetDiarySettingBinding!!.root
//    }
//
//    override fun onDestroyView() {
//        bottomSheetDiarySettingBinding = null
//        super.onDestroyView()
//    }
//
//}