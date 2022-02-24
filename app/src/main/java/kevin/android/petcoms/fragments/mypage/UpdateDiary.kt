package kevin.android.petcoms.fragments.mypage

import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PrefUtil
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.UpdateDiaryBinding
import kevin.android.petcoms.fragments.mypage.model.PutDiary
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import java.time.LocalDate

@AndroidEntryPoint
class UpdateDiary : PetComsBaseFragment<UpdateDiaryBinding>(R.layout.update_diary) {

    private val viewModel: MyPageViewModel by activityViewModels()
    private val currentDate: LocalDate = LocalDate.now()

    override fun initViews(view: View) {
        initButton()
//        binding.btnDatepicker.text = currentDate.toString()
        binding.putDiaryEditText.setText(arguments!!.getString("content"))
//        binding.btnDatepicker.text = arguments!!.getString("date")
    }

    override fun observeData() {

    }

    private fun initButton() {

        binding.btnPutDiary.setOnClickListener {
            putDiary()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }
//
//        binding.btnClose.setOnClickListener {
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.remove(this)?.commit()
//        }
//
//        binding.btnDatepicker.setOnClickListener {
//            DatePickerDialog().show(
//                parentFragmentManager, "DatePickerDialog"
//            )
//        }
//
//        binding.btnDiaryPrivate.setOnClickListener {
//            binding.btnDiaryPrivate.text = "공개"
//        }
//
    }

    private fun putDiary() {
        val putDiary = PutDiary(
            3,
            1,
            binding.putDiaryEditText.text.toString()
        )
        viewModel.putDiary(arguments?.getLong("diaryID")!!, putDiary)
    }

}