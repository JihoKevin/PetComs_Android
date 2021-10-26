package kevin.android.petcoms.fragments.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.databinding.FragmentDiaryBinding

@AndroidEntryPoint
class DiaryFragment : Fragment() {

    private var fragmentDiaryBinding: FragmentDiaryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDiaryBinding.inflate(inflater, container, false)
        fragmentDiaryBinding = binding

        return fragmentDiaryBinding!!.root
    }

    override fun onDestroyView() {
        fragmentDiaryBinding = null
        super.onDestroyView()
    }

}