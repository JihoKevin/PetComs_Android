package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kevin.android.petcoms.databinding.PutDiaryBinding
import kevin.android.petcoms.fragments.mypage.model.PutDiary
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import java.time.LocalDate

class UpdateDiary: Fragment() {

    private var putDiaryBinding : PutDiaryBinding? = null
    private val viewModel: MyPageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = PutDiaryBinding.inflate(inflater, container, false)
        putDiaryBinding = binding

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

        return putDiaryBinding!!.root

    }

    private fun putDiary() {
        val putDiary = PutDiary(3,
            1,
            putDiaryBinding!!.putDiaryEditText.text.toString(),
            5)
        viewModel.putDiary(12, putDiary)
    }

    override fun onDestroyView() {
        putDiaryBinding = null
        super.onDestroyView()
    }

}