package kevin.android.petcoms.fragments.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.SupportActionModeWrapper
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {

    private var fragmentDiaryBinding : FragmentDiaryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_diary, container, false)
        val binding = FragmentDiaryBinding.inflate(inflater, container, false)
        fragmentDiaryBinding = binding

//        return view
        return fragmentDiaryBinding!!.root
    }

    override fun onDestroyView() {
        fragmentDiaryBinding = null
        super.onDestroyView()
    }

}