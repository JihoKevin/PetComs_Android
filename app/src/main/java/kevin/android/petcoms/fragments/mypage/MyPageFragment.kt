package kevin.android.petcoms.fragments.mypage

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PrefUtil
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyDiaryAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

@AndroidEntryPoint
class MyPageFragment : PetComsBaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private val viewModel: MyPageViewModel by activityViewModels()

    override fun initViews(view: View) {
        initButton()
        initRecyclerview()
        binding.userNickname.text = viewModel.getUserId(1).toString()
        binding.userEmail.text = viewModel.getUserId(1).toString()
    }

    override fun observeData() {
        viewModel.myAccount.observe(viewLifecycleOwner, Observer {
            binding.userNickname.text = it.response.nickname
            binding.userEmail.text = it.response.email
        })
    }

    private fun initButton() {
        binding.fabDiary.setOnClickListener{
            val newDiary = NewDiary()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.myPageFragment, newDiary)?.commit()
        }

        binding.btnPetAdd.setOnClickListener{
            val addPetInfo = AddPetInfo()
            val transaction= fragmentManager?.beginTransaction()
            binding.userNickname.text = PrefUtil.get("familyButton", "")
            transaction?.replace(R.id.myPageFragment, addPetInfo)?.commit()
        }

        binding.myFamily.setOnClickListener {
            val bottomSheet = MyFamBottomSheet()
            PrefUtil.put("familyButton", "안녕하세요 누구누구 입니다.")
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }
    }

    private fun initRecyclerview() {
        viewModel.myAccount.observe(this, Observer {
            val myPetsAdapter = MyPetsAdapter(it.response.dogsName)
            binding.rvPets.adapter = myPetsAdapter
            myPetsAdapter.notifyDataSetChanged()
        })
        viewModel.myDiary.observe(this, Observer {
            val myDiaryAdapter = MyDiaryAdapter(it.response, parentFragmentManager)
            binding.rvMyDiary.adapter = myDiaryAdapter
            myDiaryAdapter.notifyDataSetChanged()
        })
    }

}