package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.databinding.NewDiaryBinding
import java.time.LocalDate

@AndroidEntryPoint
class NewDiary : Fragment() {

    private var newDiaryBinding : NewDiaryBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = NewDiaryBinding.inflate(inflater, container, false)
        newDiaryBinding = binding

        val newDiaryEditText: EditText = binding.newDiaryEditText

        binding.btnAddDiary.setOnClickListener {
            if (newDiaryEditText.text.isEmpty()){
                Toast.makeText(context, "다이어리를 작성해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 값 대입 필수

//           val newDiary = newDiaryEditText.text.toString()

            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnClose.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

//        binding.btnDatepicker.setOnClickListener{
//            val datePickerDialog = DatePickerDialog()
//            val transaction= fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.new_diary, datePickerDialog)?.commit()
//        }

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

//        return view
        return newDiaryBinding!!.root
    }

    override fun onDestroyView() {
        newDiaryBinding = null
        super.onDestroyView()
    }

}