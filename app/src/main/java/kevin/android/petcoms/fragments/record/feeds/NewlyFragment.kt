package kevin.android.petcoms.fragments.record.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.ActivityMainBinding
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.record.adapter.RecordViewPagerAdapter
import kevin.android.petcoms.fragments.record.adapter.newlyfeed.NewlyFeedAdapter
import kevin.android.petcoms.fragments.record.repository.RecordRepository
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModelFactory
import kevin.android.petcoms.models.record.RecordModel

class NewlyFragment : Fragment() {

    private lateinit var viewModel: RecordViewModel
    private lateinit var binding: FragmentPopularBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_newly, container, false)
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_newly, container, false)
//        binding.lifecycleOwner = this
//        val repository = RecordRepository()
//        val viewModelFactory = RecordViewModelFactory(repository)
//
//        viewModel = ViewModelProvider(this, viewModelFactory).get(RecordViewModel::class.java)
//        binding.recordViewModel = viewModel

        val recy = arrayListOf(
            RecordModel("9/25", "00:20", R.drawable.ic_launcher_foreground, "탄이아빠", "서울동물병원"),
            RecordModel("9/26", "00:12", R.drawable.ic_launcher_foreground, "케빈", "부산동물병원")

        )
        var recordRecy = rootView.findViewById<RecyclerView>(R.id.rcNewlyFeed!!)
        recordRecy.layoutManager = LinearLayoutManager(requireContext())
        recordRecy.adapter = NewlyFeedAdapter(recy)




        return rootView
    }

}