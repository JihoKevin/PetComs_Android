package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.BottomsheetMyfamBinding
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.databinding.NewDiaryBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyFamAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.model.MyFamily
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModelFactory

class MyFamBottomSheet: BottomSheetDialogFragment() {

//    private var bottomsheetMyfamBinding : BottomsheetMyfamBinding? = null
    private var binding: BottomsheetMyfamBinding? = null
    private lateinit var myPageViewModel: MyPageViewModel
    private lateinit var myFamAdapter: MyFamAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        val binding = BottomsheetMyfamBinding.inflate(inflater, container, false)
//        bottomsheetMyfamBinding = binding
        binding = DataBindingUtil.inflate(inflater, R.layout.bottomsheet_myfam, container, false) // databinding
        binding!!.lifecycleOwner = this

        val repository = MyPageRepository()
        val myPageViewModelFactory = MyPageViewModelFactory(repository)

        myPageViewModel = ViewModelProvider(this, myPageViewModelFactory).get(MyPageViewModel::class.java)
        binding!!.myPageViewModel = myPageViewModel

        myFamAdapter = MyFamAdapter()

//
//        myPageViewModel = ViewModelProvider(this).get(myPageViewModel::class.java)
//        myPageViewModel.myFamList.observe(this, {
//        })

//        myPageViewModel.myFamList.observe(this, Observer { myFamAdapter.setData(it) })

        return binding!!.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}