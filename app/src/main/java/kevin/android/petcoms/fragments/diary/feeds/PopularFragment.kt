package kevin.android.petcoms.fragments.diary.feeds

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PrefUtil
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.diary.adapter.AllDiaryAdapter
import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel
import kevin.android.petcoms.fragments.mypage.NewDiary
import kotlinx.android.synthetic.main.fragment_popular.*

@AndroidEntryPoint
class PopularFragment : PetComsBaseFragment<FragmentPopularBinding>(R.layout.fragment_popular) {

    private val viewModel: DiaryViewModel by activityViewModels()

    override fun initViews(view: View) {

        popularSample.text = PrefUtil.get("familyButton", "")

//        initRecyclerview()

        initButton()

    }

    private fun initButton() {
        binding.fabDiary.setOnClickListener {
            val newDiary = NewDiary()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.diaryFragment, newDiary)?.commit()
        }
    }

//    private fun initRecyclerview() {
//        viewModel.allDiary.observe(this, Observer {
//            val adapter = AllDiaryAdapter(it.response)
//            binding.rcPopularFeed.adapter = adapter
//            adapter.notifyDataSetChanged()
//        })
//    }

}