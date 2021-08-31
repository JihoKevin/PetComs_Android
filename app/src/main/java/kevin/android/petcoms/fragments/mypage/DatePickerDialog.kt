package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.DialogDatepickerBinding
import kevin.android.petcoms.databinding.NewDiaryBinding

class DatePickerDialog: DialogFragment() {

    private var dialogDatePickerBinding: DialogDatepickerBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DialogDatepickerBinding.inflate(inflater, container, false)
        dialogDatePickerBinding = binding

        return dialogDatePickerBinding!!.root
    }

    override fun onDestroyView() {
        dialogDatePickerBinding = null
        super.onDestroyView()
    }
}