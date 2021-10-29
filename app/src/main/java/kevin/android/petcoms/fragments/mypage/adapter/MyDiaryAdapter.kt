package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyDiaryBinding
import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.fragments.mypage.model.TestModel

class MyDiaryAdapter(private var data: List<TestModel>) : RecyclerView.Adapter<MyDiaryAdapter.MyDiaryViewHolder>() {

    class MyDiaryViewHolder(private val binding: ListMyDiaryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TestModel) {
            binding.testModel = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDiaryViewHolder {
        val binding = ListMyDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyDiaryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}