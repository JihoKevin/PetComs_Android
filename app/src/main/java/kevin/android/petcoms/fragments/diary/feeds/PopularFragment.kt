package kevin.android.petcoms.fragments.diary.feeds

import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.diary.viewmodel.DiaryViewModel

@AndroidEntryPoint
class PopularFragment : PetComsBaseFragment<FragmentPopularBinding>() {

    private val viewModel: DiaryViewModel by activityViewModels()

    override fun getViewBinding(): FragmentPopularBinding  = FragmentPopularBinding.inflate(layoutInflater)

    override fun observeData() {

    }


}