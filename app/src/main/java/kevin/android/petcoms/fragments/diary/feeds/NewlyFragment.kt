package kevin.android.petcoms.fragments.diary.feeds

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentNewlyBinding
import kevin.android.petcoms.fragments.diary.adapter.AllDiaryAdapter
import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel

@AndroidEntryPoint
class NewlyFragment : PetComsBaseFragment<FragmentNewlyBinding>(R.layout.fragment_newly) {

    private val viewModel: DiaryViewModel by activityViewModels()

    override fun initViews(view: View) {
        initRecyclerview()
    }

    override fun observeData() {

    }

    private fun initRecyclerview() {
        viewModel.allDiary.observe(this, Observer {
            val adapter = AllDiaryAdapter(it.response, parentFragmentManager)
            binding.rcNewlyFeed.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

}