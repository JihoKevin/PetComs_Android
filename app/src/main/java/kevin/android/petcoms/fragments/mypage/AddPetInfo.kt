package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.AddPetInfoBinding
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.model.PostMyPet
import kevin.android.petcoms.fragments.mypage.model.Sex
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kotlinx.android.synthetic.main.add_pet_info.*

@AndroidEntryPoint
class AddPetInfo: Fragment() {

    private var addPetInfoBinding : AddPetInfoBinding? = null
    private val viewModel: MyPageViewModel by activityViewModels()

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

        binding.btnAdd.setOnClickListener{

            if (edit_pet_name.text!!.isEmpty()){
                Toast.makeText(context, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            if (edit_pet_breed.text!!.isEmpty()){
//                Toast.makeText(context, "견종을 입력해주세요.", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (edit_pet_age.text!!.isEmpty()){
//                Toast.makeText(context, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }

            postMyPet()

            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        return addPetInfoBinding!!.root
    }

    private fun postMyPet() {
        val postMyPet = PostMyPet(
            addPetInfoBinding!!.editPetName.text.toString(),
            21,
            "2019-01-01",
            7f,
            Sex.M,
            3
        )
        viewModel.postMyPet(1, postMyPet)
    }

    override fun onDestroyView() {
        addPetInfoBinding = null
        super.onDestroyView()
    }

}