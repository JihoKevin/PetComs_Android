package kevin.android.petcoms.fragments.mypage

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.databinding.DialogDatepickerBinding

@AndroidEntryPoint
class DatePickerDialog: DialogFragment() {

    private var dialogDatePickerBinding: DialogDatepickerBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DialogDatepickerBinding.inflate(inflater, container, false)
        dialogDatePickerBinding = binding

        val yearList = (1950..2021).toList()
        val monthList = (1..12).toList()
        val dateList = (1..31).toList()

        val yearStrConvertList = yearList.map { it.toString() }
        val monthStrConvertList = monthList.map { it.toString() }
        val dateStrConvertList = dateList.map { it.toString() }

        binding.yearPicker.run {
            minValue = 0
            maxValue = yearStrConvertList.size - 1
            wrapSelectorWheel = false
            displayedValues = yearStrConvertList.toTypedArray()
        }

        binding.monthPicker.run {
            minValue = 0
            maxValue = monthStrConvertList.size - 1
            wrapSelectorWheel = false
            displayedValues = monthStrConvertList.toTypedArray()
        }

        binding.dayPicker.run {
            minValue = 0
            maxValue = dateStrConvertList.size - 1
            wrapSelectorWheel = false
            displayedValues = dateStrConvertList.toTypedArray()
        }

        binding.btnCancel.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

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