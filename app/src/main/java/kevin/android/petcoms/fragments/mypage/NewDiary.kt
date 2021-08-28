package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.NewDiaryBinding

class NewDiary : Fragment() {

    private var newDiaryBinding : NewDiaryBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.new_diary, container, false)
//        newDiaryBinding = binding

        return view
//        return newDiaryBinding!!.root
    }

//    override fun onDestroyView() {
//        newDiaryBinding = null
//        super.onDestroyView()
//    }

}