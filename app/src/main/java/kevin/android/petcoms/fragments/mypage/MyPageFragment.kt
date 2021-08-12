package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.MainActivity
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyDiaryAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModelFactory
import kotlinx.android.synthetic.main.fragment_mypage.*

class MyPageFragment : Fragment() {

    private var binding: FragmentMypageBinding? = null
    private lateinit var myPageViewModel: MyPageViewModel
    private lateinit var myPetsAdapter: MyPetsAdapter
    private lateinit var myDiaryAdapter: MyDiaryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypage, container, false)
        binding!!.lifecycleOwner = this

        var repository = MyPageRepository()
        val myPageViewModelFactory = MyPageViewModelFactory(repository)

        myPetsAdapter = MyPetsAdapter()
        myDiaryAdapter = MyDiaryAdapter()

        myPageViewModel = ViewModelProvider(this, myPageViewModelFactory).get(MyPageViewModel::class.java)
        binding!!.viewModel = myPageViewModel

        myPageViewModel.getPostViewModel()

        return binding!!.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}