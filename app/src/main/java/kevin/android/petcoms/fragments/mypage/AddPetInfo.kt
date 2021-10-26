package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.AddPetInfoBinding
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

@AndroidEntryPoint
class AddPetInfo: Fragment() {

    private var addPetInfoBinding : AddPetInfoBinding? = null
    private var fragmentDiaryBinding: FragmentMypageBinding? = null
    private val data = arrayListOf<MyPets>()
    private val myPageViewModel: MyPageViewModel by activityViewModels()

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

//        binding.btnAdd.setOnClickListener{
//            myPageViewModel?.btnClick()
//            val transaction= fragmentManager?.beginTransaction()
//            transaction?.remove(this)?.commit()
//        }

//        binding.btnAdd.setOnClickListener {
//            var resultPetName = binding.editPetName.text.toString()
//            binding.fakeText.text = resultPetName
//        }

//        binding.btnAdd.setOnClickListener {
//            addPets()
//        }

        return addPetInfoBinding!!.root
    }

//    fun addPets(){
//        val myPets = MyPets(addPetInfoBinding!!.editPetName.text.toString())
//        data.add(myPets)
//        fragmentDiaryBinding!!.rvPets.adapter?.notifyDataSetChanged()
//    }

    override fun onDestroyView() {
        addPetInfoBinding = null
        super.onDestroyView()
    }

}