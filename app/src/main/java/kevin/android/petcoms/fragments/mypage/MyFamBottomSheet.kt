package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.databinding.BottomsheetMyfamBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyFamAdapter
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel

@AndroidEntryPoint
class MyFamBottomSheet: BottomSheetDialogFragment() {

    private var bottomSheetMyFamBinding: BottomsheetMyfamBinding? = null
    private val viewModel: MyPageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = BottomsheetMyfamBinding.inflate(inflater, container, false)
        bottomSheetMyFamBinding = binding

        viewModel.myFamily.observe(this, Observer {
            val adapter = MyFamAdapter(it.response)
            bottomSheetMyFamBinding!!.rvMyFamily.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        return bottomSheetMyFamBinding!!.root

    }

    override fun onDestroyView() {
        bottomSheetMyFamBinding = null
        super.onDestroyView()
    }

}