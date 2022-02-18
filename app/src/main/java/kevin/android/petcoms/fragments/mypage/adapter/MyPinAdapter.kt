package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyPinBinding
import kevin.android.petcoms.fragments.mypage.model.GetMyPin

class MyPinAdapter(private var data: List<GetMyPin>): RecyclerView.Adapter<MyPinAdapter.MyPinViewHolder>() {

    class MyPinViewHolder(val binding: ListMyPinBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPinViewHolder {
        val binding = ListMyPinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPinAdapter.MyPinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPinViewHolder, position: Int) {
        holder.binding.dUserNickname.text = data[position].nickname
        holder.binding.dContents.text = data[position].text
    }

    override fun getItemCount() = data.size
}