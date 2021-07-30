package kevin.android.petcoms.fragments.record.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import kevin.android.petcoms.fragments.record.RecordFragment
import kevin.android.petcoms.fragments.record.feeds.NewlyFragment
import kevin.android.petcoms.fragments.record.feeds.PopularFragment

class RecordViewPagerAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {

    var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    fun removeFragment(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }


}