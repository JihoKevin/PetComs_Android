package kevin.android.petcoms.fragments.diary.feeds

import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PrefUtil
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel
import kotlinx.android.synthetic.main.fragment_popular.*

@AndroidEntryPoint
class PopularFragment : PetComsBaseFragment<FragmentPopularBinding>(R.layout.fragment_popular) {

    private val viewModel: DiaryViewModel by activityViewModels()


    override fun initViews(view: View) {

        popularSample.text = PrefUtil.get("familyButton", "")

    }



}