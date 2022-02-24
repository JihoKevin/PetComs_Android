package kevin.android.petcoms.fragments.mypage

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentMypageSettingBinding
import kevin.android.petcoms.fragments.mypage.model.UploadProfileImage
import kevin.android.petcoms.fragments.mypage.model.UploadProfileImageModel
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

class MyPageSettingFragment : PetComsBaseFragment<FragmentMypageSettingBinding>(R.layout.fragment_mypage_setting) {

    private val viewModel: MyPageViewModel by activityViewModels()

    override fun initViews(view: View) {
//        binding.userImg.setOnClickListener {
//            uploadProfileImage()
//        }
        Glide.with(this).load(viewModel.getUserId(1).toString()).into(binding.userImg)
        binding.userNickname.text = viewModel.getUserId(1).toString()
        binding.userEmail.text = viewModel.getUserId(1).toString()
    }

    override fun observeData() {
        viewModel.myAccount.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it.response.imageUrl).into(binding.userImg)
            binding.userNickname.text = it.response.nickname
            binding.userEmail.text = it.response.email
        })
    }

//    private fun uploadProfileImage() {
//        val uploadProfileImage = UploadProfileImage(
//            "https://cdn.pixabay.com/photo/2016/01/02/18/39/puppy-1118584_1280.jpg"
//        )
//        viewModel.uploadProfileImage(4, uploadProfileImage)
//    }

}