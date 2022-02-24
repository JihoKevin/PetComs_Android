package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kevin.android.petcoms.databinding.ListPinCountBinding
import kevin.android.petcoms.fragments.mypage.model.GetPinCount

class PinCountAdapter(private var data: List<GetPinCount>): RecyclerView.Adapter<PinCountAdapter.PinCountViewHolder>() {

    class PinCountViewHolder(val binding: ListPinCountBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinCountViewHolder {
        val binding = ListPinCountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PinCountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PinCountViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(data[position].imageurl).into(holder.binding.imgUser)
        holder.binding.userNickname.text = data[position].nickName
    }

    override fun getItemCount() = data.size

}