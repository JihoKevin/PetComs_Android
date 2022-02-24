package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kevin.android.petcoms.databinding.ListAlarmBinding
import kevin.android.petcoms.fragments.mypage.model.GetShowAlarmList

class AlarmAdapter(private var data: List<GetShowAlarmList>): RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    class AlarmViewHolder(val binding: ListAlarmBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val binding = ListAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(data[position].imageurl).into(holder.binding.aUserImg)
        holder.binding.aUserNickname.text = data[position].nickname
        holder.binding.aMessage.text = data[position].message
        holder.binding.aTime.text = data[position].createdAt
    }

    override fun getItemCount() = data.size

}