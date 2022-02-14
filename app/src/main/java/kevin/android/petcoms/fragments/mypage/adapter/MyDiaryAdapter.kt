package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kevin.android.petcoms.databinding.ListMyDiaryBinding
import kevin.android.petcoms.fragments.mypage.CommentBottomSheet
import kevin.android.petcoms.fragments.mypage.DiarySettingBottomSheet
import kevin.android.petcoms.fragments.mypage.MyFamBottomSheet
import kevin.android.petcoms.fragments.mypage.model.GetMyDiary

class MyDiaryAdapter(private var data: List<GetMyDiary>, fragmentManager: FragmentManager) : RecyclerView.Adapter<MyDiaryAdapter.MyDiaryViewHolder>() {

    private var mFragmentManager : FragmentManager

    init {
        mFragmentManager = fragmentManager
    }

    class MyDiaryViewHolder(val binding: ListMyDiaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDiaryViewHolder {
        val binding = ListMyDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyDiaryViewHolder, position: Int) {
//        holder.binding.dUserNickname.text = data[position]
        holder.binding.dDate.text = data[position].creatAt
        holder.binding.dContents.text = data[position].text

        holder.binding.dSetting.setOnClickListener {
            val bottomSheet = DiarySettingBottomSheet()
            bottomSheet.show(mFragmentManager, bottomSheet.tag)
        }
        holder.binding.dComment.setOnClickListener {
            val bottomSheet = CommentBottomSheet()
            bottomSheet.show(mFragmentManager, bottomSheet.tag)
        }
        holder.binding.dPin.setOnClickListener {
            //TODO Pin Fragment 추가 필요
        }
    }

    override fun getItemCount() = data.size

}