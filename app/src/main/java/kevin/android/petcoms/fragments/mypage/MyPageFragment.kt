package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*

class MyPageFragment : Fragment() {

    private var fragmentMypageBinding : FragmentMypageBinding? = null
    private lateinit var myPageViewModel: MyPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_mypage, container, false)
        val binding = FragmentMypageBinding.inflate(inflater, container, false)
        fragmentMypageBinding = binding

        myPageViewModel = ViewModelProvider(this).get(MyPageViewModel::class.java)
//        binding.viewModel = myPageViewModel
        myPageViewModel.myPetsList.observe(viewLifecycleOwner, Observer{
            it
        })

//        val adapter = MyPetsAdapter()
//        val adapter = recyclerView.adapter as MyPetsAdapter

//        rv_pets.adapter = adapter
//        rv_pets.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

//        return view
        return fragmentMypageBinding!!.root
    }

}