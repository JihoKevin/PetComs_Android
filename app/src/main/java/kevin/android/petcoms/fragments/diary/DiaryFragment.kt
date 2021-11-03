package kevin.android.petcoms.fragments.diary

import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentDiaryBinding
import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel

@AndroidEntryPoint
class DiaryFragment : PetComsBaseFragment<FragmentDiaryBinding>() {

    private val viewModel: DiaryViewModel by activityViewModels()

    private fun attachViewPager() {
        val viewPagerAdapter = DiaryViewPagerAdapter(requireFragmentManager(), lifecycle)
        binding!!.diaryViewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding!!.diaryTabLayout, binding!!.diaryViewPager){
                tab, position ->
            when(position){
                0 -> tab.text = "최신순"
                1 -> tab.text = "인기순"
            }
        }.attach()
    }

    override fun initViews() {
        attachViewPager()
    }

    override fun getViewBinding(): FragmentDiaryBinding = FragmentDiaryBinding.inflate(layoutInflater)

    override fun observeData() {

    }

}