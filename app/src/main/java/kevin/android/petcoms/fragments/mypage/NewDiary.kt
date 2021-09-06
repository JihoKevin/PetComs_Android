package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.DialogDatepickerBinding
import kevin.android.petcoms.databinding.NewDiaryBinding
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import java.time.LocalDate

class NewDiary : Fragment() {

    private var newDiaryBinding : NewDiaryBinding? = null
    private lateinit var myPageViewModel: MyPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        val view = inflater.inflate(R.layout.new_diary, container, false)
        val binding = NewDiaryBinding.inflate(inflater, container, false)
        newDiaryBinding = binding
//        newDiaryBinding = DataBindingUtil.setContentView(this, R.layout.new_diary)

//        binding.btnDatepicker.text = myPageViewModel.currentDate.toString() // viewbinding 이용 data 전달

        binding.btnClose.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnDatepicker.setOnClickListener{
            val datePickerDialog = DatePickerDialog()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.new_diary, datePickerDialog)?.commit()
        }

//        return view
        return newDiaryBinding!!.root
    }

    override fun onDestroyView() {
        newDiaryBinding = null
        super.onDestroyView()
    }

}