package kevin.android.petcoms.fragments.record.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.record.adapter.newlyfeed.NewlyFeedAdapter
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel
import kevin.android.petcoms.models.record.RecordModel

@AndroidEntryPoint
class NewlyFragment : Fragment() {

    private val viewModel: RecordViewModel by activityViewModels()
    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_newly, container, false)

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