package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kevin.android.petcoms.R
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kotlinx.android.synthetic.main.fragment_mypage.view.*

class MyPageFragment : Fragment() {

//    private var fragmentMypageBinding : FragmentMypageBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)
//        val binding = FragmentMypageBinding.inflate(inflater, container, false)
//        fragmentMypageBinding = binding

        val petsList = arrayListOf(
            MyPets(myPetsName = "콩순이"),
            MyPets(myPetsName = "팥순이"),
            MyPets(myPetsName = "또순이")
        )

        val adapter = MyPetsAdapter(petsList)

        view.rv_pets.adapter = adapter
        view.rv_pets.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return view
//        return fragmentMypageBinding!!.root
    }

}