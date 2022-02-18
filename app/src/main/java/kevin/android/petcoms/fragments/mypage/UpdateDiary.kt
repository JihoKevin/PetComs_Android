package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kevin.android.petcoms.databinding.UpdateDiaryBinding
import kevin.android.petcoms.fragments.mypage.model.PutDiary
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import java.time.LocalDate

class UpdateDiary: Fragment() {

    private var updateDiaryBinding : UpdateDiaryBinding? = null
    private val viewModel: MyPageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = UpdateDiaryBinding.inflate(inflater, container, false)
        updateDiaryBinding = binding

//        binding.putDiaryEditText.text = viewModel.getMyDiary(1,"성북구대장탄이","탄이").toString()

        binding.btnPutDiary.setOnClickListener {
            putDiary()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnClose.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnDatepicker.setOnClickListener {
            DatePickerDialog().show(
                parentFragmentManager, "DatePickerDialog"
            )
        }

        binding.btnDiaryPrivate.setOnClickListener {
            binding.btnDiaryPrivate.text = "공개"
        }

        val currentDate: LocalDate = LocalDate.now()
        binding.btnDatepicker.text = currentDate.toString()

        return updateDiaryBinding!!.root

    }

    private fun putDiary() {
        val putDiary = PutDiary(3,
            1,
            updateDiaryBinding!!.putDiaryEditText.text.toString(),
            5)
        viewModel.putDiary(12, putDiary)
    }

    override fun onDestroyView() {
        updateDiaryBinding = null
        super.onDestroyView()
    }

}