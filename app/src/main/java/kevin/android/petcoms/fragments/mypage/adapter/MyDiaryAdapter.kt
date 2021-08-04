package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyDiaryBinding
import kevin.android.petcoms.fragments.mypage.MyDiary


class MyDiaryAdapter() : RecyclerView.Adapter<MyDiaryAdapter.MyDiaryViewHolder>() {

    var myDiaryList = mutableListOf<MyDiary>()

    class MyDiaryViewHolder(val binding: ListMyDiaryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentMyDiary: MyDiary) {
            binding.myDiary = currentMyDiary
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDiaryAdapter.MyDiaryViewHolder {
        val binding = ListMyDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyDiaryAdapter.MyDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyDiaryAdapter.MyDiaryViewHolder, position: Int) {
        holder.bind(myDiaryList[position])
    }

    override fun getItemCount(): Int {
        return myDiaryList.size
    }

    fun setData(data : ArrayList<MyDiary>){
        myDiaryList = data
        notifyDataSetChanged()
    }

}