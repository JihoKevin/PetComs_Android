package kevin.android.petcoms.fragments.record.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import kevin.android.petcoms.fragments.record.RecordFragment
import kevin.android.petcoms.fragments.record.feeds.NewlyFragment
import kevin.android.petcoms.fragments.record.feeds.PopularFragment

class RecordViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragments : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> NewlyFragment()
            else  -> PopularFragment()
        }
    }


}