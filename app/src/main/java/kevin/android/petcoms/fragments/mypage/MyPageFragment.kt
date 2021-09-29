package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyDiaryAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModelFactory
import retrofit2.Response

class MyPageFragment : Fragment() {

    private var binding: FragmentMypageBinding? = null
    private lateinit var myPageViewModel: MyPageViewModel
    private lateinit var myPetsAdapter: MyPetsAdapter
    private lateinit var myDiaryAdapter: MyDiaryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypage, container, false)
        binding!!.lifecycleOwner = this

        val repository = MyPageRepository()
        val myPageViewModelFactory = MyPageViewModelFactory(repository)

//        myPetsAdapter = MyPetsAdapter()
        myDiaryAdapter = MyDiaryAdapter()

        myPageViewModel = ViewModelProvider(this, myPageViewModelFactory).get(MyPageViewModel::class.java)
        binding!!.myPageViewModel = myPageViewModel

//        myPageViewModel.myPetsList.observe(this, Observer {
//            binding?.rvPets?.adapter = myPetsAdapter
//        })

        myPageViewModel.getPostTestVM()
        myPageViewModel.getMyPetsVM()

        binding!!.fabDiary.setOnClickListener{
            val newDiary = NewDiary()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.myPageFragment, newDiary)?.commit()
        }

        binding!!.btnPetAdd.setOnClickListener{
            val addPetInfo = AddPetInfo()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.myPageFragment, addPetInfo)?.commit()
        }

        binding!!.myFamily.setOnClickListener {
            val bottomSheet = MyFamBottomSheet()
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}