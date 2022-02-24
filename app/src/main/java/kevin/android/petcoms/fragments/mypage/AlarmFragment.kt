package kevin.android.petcoms.fragments.mypage

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentAlarmBinding
import kevin.android.petcoms.databinding.FragmentPopularBinding
import kevin.android.petcoms.fragments.mypage.adapter.AlarmAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPinAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

class AlarmFragment: PetComsBaseFragment<FragmentAlarmBinding>(R.layout.fragment_alarm) {

    private val viewModel: MyPageViewModel by activityViewModels()

    override fun initViews(view: View) {
        viewModel.alarmList.observe(this, Observer {
            val adapter = AlarmAdapter(it.response)
            binding.rvAlarm.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    override fun observeData() {

    }

}