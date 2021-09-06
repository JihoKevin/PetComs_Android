package kevin.android.petcoms.fragments.mypage

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.system.Os.remove
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kevin.android.petcoms.MainActivity
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentDiaryBinding
import kevin.android.petcoms.databinding.FragmentMypageBinding
import kevin.android.petcoms.databinding.NewDiaryBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyDiaryAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyFamAdapter
import kevin.android.petcoms.fragments.mypage.adapter.MyPetsAdapter
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModelFactory
import java.util.*

class MyPageFragment : Fragment() {

//    private var fragmentDiaryBinding: FragmentMypageBinding? = null
    private var binding: FragmentMypageBinding? = null
    private lateinit var myPageViewModel: MyPageViewModel
    private lateinit var myPetsAdapter: MyPetsAdapter
    private lateinit var myDiaryAdapter: MyDiaryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypage, container, false) // databinding
        binding!!.lifecycleOwner = this
//        val binding = FragmentMypageBinding.inflate(inflater, container, false)
//        fragmentDiaryBinding = binding

        val repository = MyPageRepository()
        val myPageViewModelFactory = MyPageViewModelFactory(repository)

        myPetsAdapter = MyPetsAdapter()
        myDiaryAdapter = MyDiaryAdapter()

        myPageViewModel = ViewModelProvider(this, myPageViewModelFactory).get(MyPageViewModel::class.java)
        binding!!.myPageViewModel = myPageViewModel

//        myPageViewModel.getMyDiaryModel()

//        val bottomSheet = BottomSheetDialogFragment()

        binding!!.fabDiary.setOnClickListener{
            val newDiary = NewDiary()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.myPageFragment, newDiary)?.commit()
        }

        binding!!.btnPetAdd.setOnClickListener{
            val addPetInfo = AddPetInfo()
            val transaction= fragmentManager?.beginTransaction()
            transaction?.replace(R.id.myPageFragment, addPetInfo)?.commit()
        }

        binding!!.myFamily.setOnClickListener {
            val bottomSheet = MyFamBottomSheet()
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }

        //날짜 다이얼로그그
//       date_conslay_statfrag.setOnClickListener {
//
//            val dialog = AlertDialog.Builder(context).create()
//            val edialog : LayoutInflater = LayoutInflater.from(context)
//            val mView : View = edialog.inflate(R.layout.dialog_datepicker,null)
//
//            val year : NumberPicker = mView.findViewById(R.id.year_picker)
//            val month : NumberPicker = mView.findViewById(R.id.month_picker)
//            val cancel : Button = mView.findViewById(R.id.btn_cancel)
//            val save : Button = mView.findViewById(R.id.btn_save)
//
//            //  순환 안되게 막기
//            year.wrapSelectorWheel = false
//            month.wrapSelectorWheel = false
//
//            //  editText 설정 해제
//            year.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
//            month.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
//
//            //  최소값 설정
//            year.minValue = 2019
//            month.minValue = 1
//
//            //  최대값 설정
//            year.maxValue = 2020
//            month.maxValue = 12
//
//            //  취소 버튼 클릭 시
//            cancel.setOnClickListener {
//                dialog.dismiss()
//                dialog.cancel()
//            }
//
//            //  완료 버튼 클릭 시
////            save.setOnClickListener {
////                year_textview_statsfrag.text = (year.value).toString() + "년"
////                month_textview_statsfrag.text = (month.value).toString() + "월"
////                month_textview_statsfrag.text = (month.value).toString() + "일"
////
////                dialog.dismiss()
////                dialog.cancel()
////            }
//
//            dialog.setView(mView)
//            dialog.create()
//            dialog.show()
//
//        }

        return binding!!.root
    }

    override fun onDestroyView() {
//        fragmentDiaryBinding = null
        binding = null
        super.onDestroyView()
    }

}