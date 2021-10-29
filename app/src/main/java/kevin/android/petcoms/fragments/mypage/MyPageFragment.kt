package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyDiaryAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

@AndroidEntryPoint
class MyPageFragment : Fragment() {

    private var binding: FragmentMypageBinding? = null
    private val viewModel: MyPageViewModel by activityViewModels()
    private lateinit var myPetsAdapter: MyPetsAdapter
    private lateinit var myDiaryAdapter: MyDiaryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypage, container, false)
        binding!!.lifecycleOwner = this
        binding!!.myPageViewModel = viewModel

        setRV()
        btnClick()

        return binding!!.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun btnClick() {
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
    }

    private fun setRV() {
        viewModel.myPetsList.observe(this, Observer {
            myPetsAdapter = MyPetsAdapter(it)
            binding?.rvPets?.adapter = myPetsAdapter
            myPetsAdapter.notifyDataSetChanged()
        })
        viewModel.myDiaryList.observe(this, Observer {
            myDiaryAdapter = MyDiaryAdapter(it)
            binding?.rvMyDiary?.adapter = myDiaryAdapter
            myPetsAdapter.notifyDataSetChanged()
        })
    }

}