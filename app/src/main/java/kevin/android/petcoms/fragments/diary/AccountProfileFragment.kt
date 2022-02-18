package kevin.android.petcoms.fragments.diary

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentAccountProfileBinding
import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel

@AndroidEntryPoint
class AccountProfileFragment: PetComsBaseFragment<FragmentAccountProfileBinding>(R.layout.fragment_account_profile) {

    private val viewModel: DiaryViewModel by activityViewModels()

    override fun initViews(view: View) {
        binding.userNickname1.text = viewModel.getUserProfile("성북구대장탄이").toString()
        binding.userNickname2.text = viewModel.getUserProfile("성북구대장탄이").toString()
        binding.userNickname3.text = viewModel.getUserProfile("성북구대장탄이").toString()
        binding.tvIntroduction.text = viewModel.getUserProfile("성북구대장탄이").toString()
    }

    override fun observeData() {
        viewModel.userProfile.observe(viewLifecycleOwner, Observer {
            binding.userNickname1.text = it.response[0].nickName
            binding.userNickname2.text = it.response[0].nickName
            binding.userNickname3.text = it.response[0].nickName
            binding.tvIntroduction.text = it.response[0].introduction
        })
    }

    //TODO 반려견 RV

}