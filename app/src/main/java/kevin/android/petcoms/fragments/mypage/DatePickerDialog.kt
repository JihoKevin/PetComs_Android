package kevin.android.petcoms.fragments.mypage

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.DialogDatepickerBinding
import kevin.android.petcoms.databinding.NewDiaryBinding

class DatePickerDialog: DialogFragment() {

    private var dialogDatePickerBinding: DialogDatepickerBinding? = null
//    private var newDiaryBinding : NewDiaryBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DialogDatepickerBinding.inflate(inflater, container, false)
        dialogDatePickerBinding = binding

//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

//        binding.yearPicker.minValue = 1900
//        binding.yearPicker.maxValue = 2021
//        binding.monthPicker.minValue = 1
//        binding.monthPicker.maxValue = 12
//        binding.dayPicker.minValue = 1
//        binding.dayPicker.maxValue = 31

        var yearList = (1950..2020).toList()
        var monthList = (1..12).toList()
        var dateList = (1..31).toList()

        var yearStrConvertList = yearList.map { it.toString() }
        var monthStrConvertList = monthList.map { it.toString() }
        var dateStrConvertList = dateList.map { it.toString() }

        binding.yearPicker.run { minValue = 0
            maxValue = yearStrConvertList.size - 1
            wrapSelectorWheel = false
            displayedValues = yearStrConvertList.toTypedArray()
        }

        binding.monthPicker.run { minValue = 0
            maxValue = monthStrConvertList.size - 1
            wrapSelectorWheel = false
            displayedValues = monthStrConvertList.toTypedArray()
        }

        binding.dayPicker.run { minValue = 0
            maxValue = dateStrConvertList.size - 1
            wrapSelectorWheel = false
            displayedValues = dateStrConvertList.toTypedArray()
        }

        binding.btnCancel.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

//        binding.btnSave.setOnClickListener{
//            newDiaryBinding!!.btnDatepicker.text = (binding.datePicker).toString()
//        }

        return dialogDatePickerBinding!!.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onDestroyView() {
        dialogDatePickerBinding = null
        super.onDestroyView()
    }
}