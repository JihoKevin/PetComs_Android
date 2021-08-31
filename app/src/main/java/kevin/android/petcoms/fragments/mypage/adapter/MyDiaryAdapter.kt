package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.ListMyDiaryBinding
import kevin.android.petcoms.fragments.mypage.MyDiary
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import retrofit2.Response


class MyDiaryAdapter() : RecyclerView.Adapter<MyDiaryAdapter.MyDiaryViewHolder>() {

    var myDiaryList = mutableListOf<MyDiary>()

    class MyDiaryViewHolder(val binding: ListMyDiaryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentMyDiary: MyDiary) {
            binding.myDiary = currentMyDiary
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDiaryViewHolder {
        val binding = ListMyDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyDiaryViewHolder, position: Int) {
        holder.bind(myDiaryList[position])
    }

    override fun getItemCount(): Int {
        return myDiaryList.size
    }

    fun setData(data : MutableList<MyDiary>){
        myDiaryList = data
        notifyDataSetChanged()
    }

}