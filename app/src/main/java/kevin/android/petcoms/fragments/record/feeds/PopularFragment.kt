package kevin.android.petcoms.fragments.record.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel

@AndroidEntryPoint
class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    private val viewModel: RecordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_popular, container, false)
        binding.lifecycleOwner = this
        binding.recordViewModel = viewModel

        // 이 부분이 레이아웃 파일에 선언된 변수에 웹서버에서 가져온 값을 붙여주는 최종 부분
        viewModel.getPostViewModel()




        return binding.root
    }

}