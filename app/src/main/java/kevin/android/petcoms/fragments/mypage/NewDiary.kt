package kevin.android.petcoms.fragments.mypage

import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PrefUtil
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.NewDiaryBinding
import kevin.android.petcoms.fragments.mypage.model.PostDiary
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import java.time.LocalDate

@AndroidEntryPoint
class NewDiary : PetComsBaseFragment<NewDiaryBinding>(R.layout.new_diary) {

    private val viewModel: MyPageViewModel by activityViewModels()
    private val currentDate: LocalDate = LocalDate.now()

    override fun initViews(view: View) {
        initButton()
//        binding.btnDatepicker.text = currentDate.toString()
    }

    override fun observeData() {

    }

    private fun initButton() {

        binding.btnAddDiary.setOnClickListener {
            if (binding.newDiaryEditText.text!!.isEmpty()) {
                Toast.makeText(context, "다이어리를 작성해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            postDiary()

            val transaction = fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

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
//        binding.btnDiaryPrivate.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                binding.btnDiaryPrivate.text = "공개"
//            } else {
//                binding.btnDiaryPrivate.text = "비공개"
//            }
//        }

    }

    private fun postDiary() {
        val postDiary = PostDiary(
            1,
            3,
            1,
            1,
            binding.newDiaryEditText.text.toString(),
            "null",
            "삼선동1가14",
            "한성대입구역",
            "37.588197",
            "127.005926"
        )
        viewModel.postDiary(postDiary)
    }

}

