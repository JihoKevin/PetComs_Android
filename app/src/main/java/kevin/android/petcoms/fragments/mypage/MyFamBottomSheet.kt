package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.BottomsheetMyfamBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyFamAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

@AndroidEntryPoint
class MyFamBottomSheet: BottomSheetDialogFragment() {

    private var binding: BottomsheetMyfamBinding? = null
    private val myPageViewModel: MyPageViewModel by activityViewModels()
    private lateinit var adapter: MyFamAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.bottomsheet_myfam, container, false) // databinding
        binding!!.lifecycleOwner = this
        binding!!.myPageViewModel = myPageViewModel

        myPageViewModel.myFamList.observe(this, Observer {
            adapter = MyFamAdapter(it)
            binding?.rvMyFamily?.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        return binding!!.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}