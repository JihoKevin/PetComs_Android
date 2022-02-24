package kevin.android.petcoms.fragments.diary

//import android.view.View
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.Observer
//import com.bumptech.glide.Glide
//import kevin.android.petcoms.R
//import kevin.android.petcoms.base.PetComsBaseFragment
//import kevin.android.petcoms.databinding.FragmentDogProfileBinding
//import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel
//
//class DogProfileFragment : PetComsBaseFragment<FragmentDogProfileBinding>(R.layout.fragment_dog_profile) {
//
//    private val viewModel: DiaryViewModel by activityViewModels()
//
//    override fun initViews(view: View) {
//        Glide.with(this).load(viewModel.getDogProfile("성북구대장탄이", "탄이")).into(binding.imgPet)
//        binding.userPetName.text = viewModel.getUserProfile("성북구대장탄이").toString()
//        binding.userPetBreed.text = viewModel.getUserProfile("성북구대장탄이").toString()
//        binding.userPetAge.text = viewModel.getUserProfile("성북구대장탄이").toString()
//    }
//
//    override fun observeData() {
//        viewModel.dogProfile.observe(viewLifecycleOwner, Observer {
//            Glide.with(this).load(it.response[0].imageurl).into(binding.imgPet)
//            binding.userPetName.text = it.response[0].name
//            binding.userPetBreed.text = it.response[0].breed
//            binding.userPetAge.text = it.response[0].age.toString()
//        })
//    }
//
//}