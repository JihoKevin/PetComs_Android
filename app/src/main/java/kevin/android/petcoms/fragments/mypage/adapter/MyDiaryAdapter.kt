package kevin.android.petcoms.fragments.mypage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kevin.android.petcoms.databinding.BottomsheetDiarySettingBinding
import kevin.android.petcoms.databinding.ListMyDiaryBinding
import kevin.android.petcoms.fragments.mypage.DiarySettingBottomSheet
import kevin.android.petcoms.fragments.mypage.model.TestModel

class MyDiaryAdapter(private var data: List<TestModel>) : RecyclerView.Adapter<MyDiaryAdapter.MyDiaryViewHolder>() {

    class MyDiaryViewHolder(val binding: ListMyDiaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDiaryViewHolder {
        val binding = ListMyDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyDiaryViewHolder, position: Int) {
        holder.binding.dUserNickname.text = data[position].username
        holder.binding.dDate.text = data[position].email
        holder.binding.dContents.text = data[position].phone

        holder.binding.dSetting.setOnClickListener {

        }
        holder.binding.dContents.setOnClickListener {

        }
        holder.binding.dPin.setOnClickListener {

        }
    }

    override fun getItemCount() = data.size

}