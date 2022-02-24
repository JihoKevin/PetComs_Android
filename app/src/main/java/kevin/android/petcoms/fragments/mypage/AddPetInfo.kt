package kevin.android.petcoms.fragments.mypage

import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.AddPetInfoBinding
import kevin.android.petcoms.fragments.mypage.model.PostMyPet
import kevin.android.petcoms.fragments.mypage.model.Sex
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kotlinx.android.synthetic.main.add_pet_info.*

@AndroidEntryPoint
class AddPetInfo : PetComsBaseFragment<AddPetInfoBinding>(R.layout.add_pet_info) {

    private val viewModel: MyPageViewModel by activityViewModels()

    override fun initViews(view: View) {
        initButton()
    }

    override fun observeData() {

    }

    private fun initButton() {
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
    }

    private fun postMyPet() {
        val postMyPet = PostMyPet(
            binding.editPetName.text.toString(),
            21,
            "2019-01-01",
            7f,
            Sex.M,
            3,
            0
        )
        viewModel.postMyPet(1, postMyPet)
    }

}