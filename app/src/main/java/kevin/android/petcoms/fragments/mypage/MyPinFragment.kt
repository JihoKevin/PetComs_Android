package kevin.android.petcoms.fragments.mypage

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentMyPinBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyPinAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

@AndroidEntryPoint
class MyPinFragment: PetComsBaseFragment<FragmentMyPinBinding>(R.layout.fragment_my_pin) {

    private val viewModel: MyPageViewModel by activityViewModels()

    override fun initViews(view: View) {
        viewModel.myPin.observe(this, Observer {
            val adapter = MyPinAdapter(it.response)
            binding.rvMyPin.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

}