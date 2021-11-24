package kevin.android.petcoms.fragments.record

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentRecordBinding
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel

@AndroidEntryPoint
class RecordFragment : PetComsBaseFragment<FragmentRecordBinding>(R.layout.fragment_record) {

    private val viewModel: RecordViewModel by activityViewModels()

    override fun initViews(view: View) {
        binding.txtTest.setOnClickListener {
            viewModel.getComments(2)
        }
    }

    override fun observeData() {
        viewModel.comments.observe(viewLifecycleOwner, Observer {
            binding.txtTest.text = it.response.toString()
        })
    }
}



