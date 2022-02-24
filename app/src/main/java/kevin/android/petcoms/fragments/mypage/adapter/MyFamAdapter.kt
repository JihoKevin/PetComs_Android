package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kevin.android.petcoms.databinding.ListMyFamilyBinding
import kevin.android.petcoms.fragments.mypage.model.GetFamily

class MyFamAdapter(private var data: List<GetFamily>): RecyclerView.Adapter<MyFamAdapter.MyFamViewHolder>() {

    class MyFamViewHolder(val binding: ListMyFamilyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFamViewHolder {
        val binding = ListMyFamilyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyFamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyFamViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(data[position].imageUrl).into(holder.binding.imgFamily)
        holder.binding.familyName.text = data[position].name
    }

    override fun getItemCount() = data.size

}