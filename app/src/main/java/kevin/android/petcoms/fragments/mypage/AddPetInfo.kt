package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.AddPetInfoBinding

class AddPetInfo: Fragment() {

    private var addPetInfoBinding : AddPetInfoBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = AddPetInfoBinding.inflate(inflater, container, false)
        addPetInfoBinding = binding

        binding.btnClose.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnDatepicker.setOnClickListener{
            val datePickerDialog = DatePickerDialog()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.add_pet_info, datePickerDialog)?.commit()
        }

//        binding.btnAdd.setOnClickListener {
//            var resultPetName = binding.editPetName.text.toString()
//            binding.fakeText.text = resultPetName
//        }

        return addPetInfoBinding!!.root
    }

    override fun onDestroyView() {
        addPetInfoBinding = null
        super.onDestroyView()
    }

}